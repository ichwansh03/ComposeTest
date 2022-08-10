package com.dikasihnama.composetest

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dikasihnama.composetest.menu.homeLayout
import com.dikasihnama.composetest.menu.mapsLayout
import com.dikasihnama.composetest.menu.profileLayout

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = NavBarLayout.Home.route){
        composable(route = NavBarLayout.Home.route){
            homeLayout()
        }
        composable(route = NavBarLayout.Maps.route){
            mapsLayout()
        }
        composable(route = NavBarLayout.Profile.route){
            profileLayout()
        }
    }
}