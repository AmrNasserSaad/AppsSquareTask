package com.example.appssquaretaskmovieapp.data.remote.restaurant


import com.google.gson.annotations.SerializedName

data class Restaurant(
    val address: String,
    val id: Int,
    val image: String,
    val name: String,
    val products: List<Product>,
    @SerializedName("restaurant_lat")
    val restaurantLat: String,
    @SerializedName("restaurant_long")
    val restaurantLong: String
)