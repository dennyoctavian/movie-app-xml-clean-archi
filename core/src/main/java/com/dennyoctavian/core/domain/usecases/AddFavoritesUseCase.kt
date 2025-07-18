package com.dennyoctavian.core.domain.usecases

import com.dennyoctavian.core.domain.models.MovieEntity

interface AddFavoritesUseCase {
    suspend  fun addFavorite(movie: MovieEntity)
}
