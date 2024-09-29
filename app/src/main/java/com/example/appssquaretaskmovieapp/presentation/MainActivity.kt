package com.example.appssquaretaskmovieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appssquaretaskmovieapp.navigation.AppNavigation
import com.example.appssquaretaskmovieapp.presentation.home.restaurant.RestaurantList
import com.example.appssquaretaskmovieapp.presentation.ui.theme.AppsSquareTaskMovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppsSquareTaskMovieAppTheme {
                //AppNavigation()
                RestaurantList()
            }
        }
    }
}

