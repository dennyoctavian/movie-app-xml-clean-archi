package com.dennyoctavian.movieappcleanarchitecture.domain.usecases

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity

interface AddFavoritesUseCase {
    suspend  fun addFavorite(movie: MovieEntity)
}
