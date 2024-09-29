package com.example.appssquaretaskmovieapp.data.remote.restaurant


data class RestaurantResponse(
    val count: Int,
    val data: List<Restaurant>,
    val message: String,
    val status: Boolean
)