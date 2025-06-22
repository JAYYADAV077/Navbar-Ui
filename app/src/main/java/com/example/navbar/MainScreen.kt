package com.example.navbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.navbar.pages.HomePage
import com.example.navbar.pages.NotificationPage
import com.example.navbar.pages.SettingPage

@Composable
fun MainScreen() {

    var slectedIndex by remember { mutableIntStateOf(0) }

    val navList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Notification", Icons.Default.Notifications),
        NavItem("Settings", Icons.Default.Settings),

        )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = slectedIndex == index,
                        onClick = { slectedIndex = index },
                        icon = { Icon(navItem.icon, contentDescription = "") },
                        label = { Text(text = navItem.label) }
                    )
                }
            }
        }
    )
    { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),slectedIndex)

    }

}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedIndex: Int) {
    when(selectedIndex){
        0-> HomePage()
        1-> NotificationPage()
        2-> SettingPage()
    }

}

