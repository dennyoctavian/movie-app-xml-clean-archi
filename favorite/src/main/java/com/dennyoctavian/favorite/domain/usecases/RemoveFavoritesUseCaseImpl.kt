package com.dennyoctavian.favorite.domain.usecases

import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.favorite.domain.repository.IFavoriteMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoveFavoritesUseCaseImpl @Inject constructor(private val repository: IFavoriteMovieRepository):
    RemoveFavoritesUseCase {
    override suspend fun removeFavorite(movie: MovieEntity) {
        repository.removeFavorite(movie)
    }
}