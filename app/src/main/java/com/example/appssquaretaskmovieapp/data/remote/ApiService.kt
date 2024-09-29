package com.example.appssquaretaskmovieapp.data.remote

import com.example.appssquaretaskmovieapp.data.remote.cite.City
import com.example.appssquaretaskmovieapp.data.remote.register.LoginRequest
import com.example.appssquaretaskmovieapp.data.remote.register.LoginResponse
import com.example.appssquaretaskmovieapp.data.remote.register.SignUpRequest
import com.example.appssquaretaskmovieapp.data.remote.register.SignUpResponse
import com.example.appssquaretaskmovieapp.data.remote.restaurant.RestaurantResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("api/sign_up")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<SignUpResponse>

    @POST("api/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @GET("api/cities")
    suspend fun getCities(): Response<List<City>>

    @GET("api/restaurants")
    suspend fun getRestaurants(): RestaurantResponse
}

