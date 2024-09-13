package com.example.appssquaretaskmovieapp.data.remote.register

data class SignUpResponse(
    val success: Boolean,
    val message: String,
    val data: UserData?
)

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val token: String?,
    val data: UserData?
)

data class UserData(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val city: String
)
