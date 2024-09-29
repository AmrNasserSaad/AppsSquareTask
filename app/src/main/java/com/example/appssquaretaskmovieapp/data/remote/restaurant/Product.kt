package com.example.appssquaretaskmovieapp.data.remote.restaurant


import com.google.gson.annotations.SerializedName

data class Product(
    val id: Int,
    val image: String,
    val name: String,
    val price: Int,
    val quantity: Int,
    @SerializedName("restaurant_id")
    val restaurantId: Int
)