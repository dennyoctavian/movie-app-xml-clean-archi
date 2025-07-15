package com.dennyoctavian.movieappcleanarchitecture.domain.usecases

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity

interface RemoveFavoritesUseCase {
    suspend  fun removeFavorite(movie: MovieEntity)
}
