package com.dennyoctavian.core.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.core.domain.usecases.GetFavoritesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getFavoritesUseCase: GetFavoritesUseCase
) : ViewModel() {

    private val _favorites = MutableStateFlow<List<MovieEntity>>(emptyList())
    val favorites: StateFlow<List<MovieEntity>> = _favorites.asStateFlow()

    fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = getFavoritesUseCase.getFavorites()
        }
    }
}
