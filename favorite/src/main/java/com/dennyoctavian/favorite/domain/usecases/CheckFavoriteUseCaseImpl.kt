package com.dennyoctavian.favorite.domain.usecases

import com.dennyoctavian.favorite.domain.repository.IFavoriteMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CheckFavoriteUseCaseImpl @Inject constructor(private val repository: IFavoriteMovieRepository):
    CheckFavoriteUseCase {
    override suspend fun isFavorite(id: Long): Boolean {
        return repository.isFavorite(id)
    }
}