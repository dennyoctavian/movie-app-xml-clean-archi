package com.dennyoctavian.core.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.core.domain.usecases.GetDetailMovieUseCase
import com.dennyoctavian.favorite.domain.usecases.AddFavoritesUseCase
import com.dennyoctavian.favorite.domain.usecases.CheckFavoriteUseCase
import com.dennyoctavian.favorite.domain.usecases.RemoveFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val getDetailMovieUseCase: GetDetailMovieUseCase,
    private val checkFavoriteUseCase: CheckFavoriteUseCase,
    private val addFavoritesUseCase: AddFavoritesUseCase,
    private val removeFavoritesUseCase: RemoveFavoritesUseCase
) : ViewModel() {

    private val _movie = MutableStateFlow<com.dennyoctavian.core.domain.models.MovieDetailEntity?>(null)
    val movie: StateFlow<com.dennyoctavian.core.domain.models.MovieDetailEntity?> = _movie.asStateFlow()

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    fun getDetailMovie(movieId: Long?) {
        viewModelScope.launch {
            if (movieId == null) return@launch
            _movie.value = null
            val movie = getDetailMovieUseCase.getDetailMovie(movieId)
            _movie.value = movie
        }
    }

    fun checkFavorite(movieId: Long?) {
        viewModelScope.launch {
            if (movieId == null) return@launch
            val isFavorite = checkFavoriteUseCase.isFavorite(movieId)
            Log.d("DetailMovieViewModel", "checkFavorite: $movieId $isFavorite")
            _isFavorite.value = isFavorite
        }
    }

    fun addFavorites(movie: MovieEntity) {
        viewModelScope.launch {
            addFavoritesUseCase.addFavorite(movie)
            checkFavorite(movie.id)
        }
    }

    fun removeFavorites(movie: MovieEntity) {
        viewModelScope.launch {
            removeFavoritesUseCase.removeFavorite(movie)
            checkFavorite(movie.id)
        }
    }
}
