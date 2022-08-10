package com.dikasihnama.composetest

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.android.material.bottomappbar.BottomAppBar

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(bottomBar = {bottomBar(navController = navController)}) {
        BottomNavGraph(navController = navController)    
    }
}

@Composable
fun bottomBar(navController: NavHostController){
    val layout = listOf(
        NavBarLayout.Home,
        NavBarLayout.Maps,
        NavBarLayout.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        layout.forEach { layout ->
            AddItem(
                layout = layout,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    layout: NavBarLayout,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        label = {Text(text = layout.title)},
        icon = {Icon(imageVector = layout.icon, contentDescription = "Navigation Icon")},
        selected = currentDestination?.hierarchy?.any { it.route == layout.route } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = { navController.navigate(layout.route) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
        }
    )
}