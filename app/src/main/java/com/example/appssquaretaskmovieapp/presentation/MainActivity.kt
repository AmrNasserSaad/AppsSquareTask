package com.example.appssquaretaskmovieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appssquaretaskmovieapp.navigations.AppNavigation
import com.example.appssquaretaskmovieapp.presentation.ui.theme.AppsSquareTaskMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppsSquareTaskMovieAppTheme {
                AppNavigation()
            }
        }
    }
}

