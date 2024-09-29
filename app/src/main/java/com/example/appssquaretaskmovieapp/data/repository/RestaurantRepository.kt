package com.example.appssquaretaskmovieapp.data.repository

import com.example.appssquaretaskmovieapp.data.remote.ApiService
import com.example.appssquaretaskmovieapp.data.remote.restaurant.Restaurant
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun fetchRestaurants(): List<Restaurant> = apiService.getRestaurants().data
}
