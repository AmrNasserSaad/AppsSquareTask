package com.example.appssquaretaskmovieapp.data.repository

import com.example.appssquaretaskmovieapp.data.remote.ApiService
import com.example.appssquaretaskmovieapp.data.remote.register.LoginRequest
import com.example.appssquaretaskmovieapp.data.remote.register.LoginResponse
import com.example.appssquaretaskmovieapp.data.remote.register.SignUpRequest
import com.example.appssquaretaskmovieapp.data.remote.register.SignUpResponse
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun signUp(signUpRequest: SignUpRequest): Response<SignUpResponse> {
        return apiService.signUp(signUpRequest)
    }

    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return apiService.login(loginRequest)
    }
}
