package com.dennyoctavian.favorite.domain.usecases

interface CheckFavoriteUseCase {
    suspend  fun isFavorite(id: Long): Boolean
}