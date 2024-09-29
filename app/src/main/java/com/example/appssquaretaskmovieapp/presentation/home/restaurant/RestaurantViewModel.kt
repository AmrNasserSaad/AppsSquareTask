package com.example.appssquaretaskmovieapp.presentation.home.restaurant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appssquaretaskmovieapp.data.remote.restaurant.Restaurant
import com.example.appssquaretaskmovieapp.data.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState: StateFlow<UIState> = _uiState

    init {
        fetchRestaurants()
    }

    private fun fetchRestaurants() {
        viewModelScope.launch {
            try {
                val restaurants = repository.fetchRestaurants()
                _uiState.value = UIState.Success(restaurants)
            } catch (e: Exception) {
                _uiState.value = UIState.Error("Failed to fetch data")
            }
        }
    }
}

// for restaurant vm
sealed class UIState {
    object Loading : UIState()
    data class Success(val restaurants: List<Restaurant>) : UIState()
    data class Error(val message: String) : UIState()
}
