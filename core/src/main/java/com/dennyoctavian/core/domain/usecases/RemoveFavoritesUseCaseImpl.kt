package com.dennyoctavian.core.domain.usecases

import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.core.domain.repository.IFavoriteMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoveFavoritesUseCaseImpl @Inject constructor(private val repository: IFavoriteMovieRepository): RemoveFavoritesUseCase {
    override suspend fun removeFavorite(movie: MovieEntity) {
        repository.removeFavorite(movie)
    }
}