package com.dennyoctavian.core.domain.usecases

interface CheckFavoriteUseCase {
    suspend  fun isFavorite(id: Long): Boolean
}