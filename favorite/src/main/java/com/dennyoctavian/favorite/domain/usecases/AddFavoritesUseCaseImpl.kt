package com.dennyoctavian.favorite.domain.usecases

import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.favorite.domain.repository.IFavoriteMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddFavoritesUseCaseImpl @Inject constructor(private val repository: IFavoriteMovieRepository):
    AddFavoritesUseCase {
    override suspend fun addFavorite(movie: MovieEntity) {
        repository.addFavorite(movie)
    }
}