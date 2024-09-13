package com.example.appssquaretaskmovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appssquaretaskmovieapp.presentation.home.cite_detail.CiteDetailsScreen
import com.example.appssquaretaskmovieapp.presentation.home.popular_cities.HomeScreen
import com.example.appssquaretaskmovieapp.presentation.login.LoginScreen
import com.example.appssquaretaskmovieapp.presentation.sign_up.SignUpScreen
import com.example.appssquaretaskmovieapp.presentation.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()



    NavHost(navController = navController, startDestination = "SPLASH_SCREEN") {
        composable("SPLASH_SCREEN") {
            SplashScreen(navController = navController)
        }
        composable("SIGN_UP") {
            SignUpScreen(navController = navController)
        }
        composable("LOGIN") {
            LoginScreen(navController = navController)
        }
        composable("HOME") {
            HomeScreen(navController = navController)
        }
        composable("CiteDetailsScreen") {
            CiteDetailsScreen(navController = navController)
        }
    }

}