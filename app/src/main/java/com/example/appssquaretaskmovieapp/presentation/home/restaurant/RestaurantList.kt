package com.example.appssquaretaskmovieapp.presentation.home.restaurant

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.appssquaretaskmovieapp.data.remote.restaurant.Product
import com.example.appssquaretaskmovieapp.data.remote.restaurant.Restaurant

@Composable
fun RestaurantList(viewModel: RestaurantViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UIState.Loading -> {
            CircularProgressIndicator()
        }

        is UIState.Success -> {
            LazyColumn {
                Log.d("TAG", "RestaurantList: Success call  ")
                item {
                    Text("Header")
                }
                items((uiState as UIState.Success).restaurants.take(10)) { restaurant ->
                    RestaurantItem(restaurant)
                }
            }
        }

        is UIState.Error -> {
            Text(text = (uiState as UIState.Error).message)
        }
    }
}

@Composable
fun RestaurantItem(restaurant: Restaurant) {
    Column {
        Text(text = restaurant.name)
        Text(text = restaurant.address)
        Image(
            painter = rememberAsyncImagePainter(restaurant.image),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        Box (
            modifier = Modifier.fillMaxWidth().height(100.dp)
        ){
            LazyColumn {
                items(restaurant.products) { product ->
                    ProductItem(product)
                }
            }
        }

    }
}

@Composable
fun ProductItem(product: Product) {
    Row {
        Image(
            painter = rememberAsyncImagePainter(product.image),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Column {
            Text(text = product.name)
            Text(text = "Price: ${product.price}")
            Text(text = "Quantity: ${product.quantity}")
        }
    }
}
