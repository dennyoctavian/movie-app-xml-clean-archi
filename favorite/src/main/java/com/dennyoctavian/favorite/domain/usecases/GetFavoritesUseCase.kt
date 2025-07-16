package com.dennyoctavian.favorite.domain.usecases

import com.dennyoctavian.core.domain.models.MovieEntity

interface GetFavoritesUseCase {
    suspend  fun getFavorites(): List<MovieEntity>
}
