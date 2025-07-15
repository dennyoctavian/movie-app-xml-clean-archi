package com.dennyoctavian.movieappcleanarchitecture.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ListMovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movies = MutableStateFlow<List<MovieEntity>>(emptyList())
    val movies: StateFlow<List<MovieEntity>> = _movies.asStateFlow()

    fun getMovies() {
        viewModelScope.launch {
            val movies = getMoviesUseCase.getMovies()
            _movies.value = movies
        }
    }
}
