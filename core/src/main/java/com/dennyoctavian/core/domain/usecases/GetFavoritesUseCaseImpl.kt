package com.dennyoctavian.core.domain.usecases

import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.core.domain.repository.IFavoriteMovieRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GetFavoritesUseCaseImpl @Inject constructor(private val repository: IFavoriteMovieRepository): GetFavoritesUseCase {
    override suspend fun getFavorites(): List<MovieEntity> {
        return repository.getFavorites()
    }
}
