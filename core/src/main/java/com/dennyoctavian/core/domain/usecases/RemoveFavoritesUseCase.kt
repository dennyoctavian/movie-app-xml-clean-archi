package com.dennyoctavian.core.domain.usecases

import com.dennyoctavian.core.domain.models.MovieEntity

interface RemoveFavoritesUseCase {
    suspend  fun removeFavorite(movie: MovieEntity)
}
