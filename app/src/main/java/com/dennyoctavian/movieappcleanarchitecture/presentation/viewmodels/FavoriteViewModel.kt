package com.dennyoctavian.movieappcleanarchitecture.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.GetFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class FavoriteViewModel @Inject constructor(
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
