package com.example.appssquaretaskmovieapp.presentation.home.popular_cities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appssquaretaskmovieapp.common.UiState
import com.example.appssquaretaskmovieapp.data.remote.cite.City
import com.example.appssquaretaskmovieapp.data.repository.CiteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val citeRepository: CiteRepository
) : ViewModel() {

    private val _cityState = MutableStateFlow<UiState<List<City>>>(UiState.Loading)
    val cityState: StateFlow<UiState<List<City>>> = _cityState.asStateFlow()


    fun getCities() {
        viewModelScope.launch {
            _cityState.value = UiState.Loading // Set loading state
            try {
                val response = citeRepository.getCities()
                if (response.isSuccessful && response.body() != null) {
                    _cityState.value = UiState.Success(response.body()!!)
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                    _cityState.value = UiState.Error("API error: $errorMessage")
                }
            } catch (e: IOException) {
                _cityState.value = UiState.Error("Network error: ${e.message}")
            } catch (e: Exception) {
                _cityState.value = UiState.Error("Unexpected error: ${e.message}")
            }
        }
    }
}