package com.dennyoctavian.movieappcleanarchitecture.domain.usecases

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity

interface GetFavoritesUseCase {
    suspend  fun getFavorites(): List<MovieEntity>
}
