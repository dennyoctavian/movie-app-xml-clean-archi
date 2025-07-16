package com.dennyoctavian.favorite.domain.usecases

interface AddFavoritesUseCase {
    suspend  fun addFavorite(movie: com.dennyoctavian.core.domain.models.MovieEntity)
}
