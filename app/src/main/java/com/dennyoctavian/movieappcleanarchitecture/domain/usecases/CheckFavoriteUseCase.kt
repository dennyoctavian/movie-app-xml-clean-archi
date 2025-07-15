package com.dennyoctavian.movieappcleanarchitecture.domain.usecases

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity

interface CheckFavoriteUseCase {
    suspend  fun isFavorite(id: Long): Boolean
}