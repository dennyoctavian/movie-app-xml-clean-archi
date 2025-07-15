package com.dennyoctavian.movieappcleanarchitecture.domain.usecases

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity
import com.dennyoctavian.movieappcleanarchitecture.domain.repository.IFavoriteMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoveFavoritesUseCaseImpl @Inject constructor(private val repository: IFavoriteMovieRepository): RemoveFavoritesUseCase {
    override suspend fun removeFavorite(movie: MovieEntity) {
        repository.removeFavorite(movie)
    }
}