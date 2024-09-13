package com.example.appssquaretaskmovieapp.data.remote.register

data class SignUpRequest(
    val email: String,
    val password: String,
    val phone: String,
    val city: String
)

data class LoginRequest(
    val email: String,
    val password: String
)
