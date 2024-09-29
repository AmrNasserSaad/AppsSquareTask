package com.example.appssquaretaskmovieapp.data.repository

import com.example.appssquaretaskmovieapp.data.remote.ApiService
import com.example.appssquaretaskmovieapp.data.remote.cite.City
import retrofit2.Response
import javax.inject.Inject

class CiteRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getCities(): Response<List<City>> {
        return apiService.getCities()
    }
}