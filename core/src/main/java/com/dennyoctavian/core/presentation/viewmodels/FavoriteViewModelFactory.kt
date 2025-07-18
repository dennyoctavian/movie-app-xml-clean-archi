package com.dennyoctavian.core.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dennyoctavian.core.domain.usecases.GetFavoritesUseCase

class FavoriteViewModelFactory(
    private val getFavoriteMoviesUseCase: GetFavoritesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            return FavoriteViewModel(getFavoriteMoviesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
