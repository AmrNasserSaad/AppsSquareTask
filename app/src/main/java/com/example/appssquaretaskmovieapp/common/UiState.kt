package com.example.appssquaretaskmovieapp.common

sealed class UiState<out T> {

    // for cite vm (home )
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}
