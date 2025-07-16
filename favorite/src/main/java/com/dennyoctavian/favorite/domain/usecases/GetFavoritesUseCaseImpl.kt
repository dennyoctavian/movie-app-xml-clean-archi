package com.dennyoctavian.favorite.domain.usecases

import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.favorite.domain.repository.IFavoriteMovieRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GetFavoritesUseCaseImpl @Inject constructor(private val repository: IFavoriteMovieRepository):
    GetFavoritesUseCase {
    override suspend fun getFavorites(): List<MovieEntity> {
        return repository.getFavorites()
    }
}
