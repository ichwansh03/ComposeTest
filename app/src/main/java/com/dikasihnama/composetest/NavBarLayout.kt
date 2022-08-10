package com.dikasihnama.composetest

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavBarLayout(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : NavBarLayout(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Maps : NavBarLayout(
        route = "maps",
        title = "Maps",
        icon = Icons.Default.Place
    )

    object Profile : NavBarLayout(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}