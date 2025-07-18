package com.dennyoctavian.core.data.repository

import com.dennyoctavian.core.data.datasource.local.FavoriteMovieDao
import com.dennyoctavian.core.data.datasource.local.toDomainEntity
import com.dennyoctavian.core.data.datasource.local.toRoomEntity
import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.core.domain.repository.IFavoriteMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteMovieRepository @Inject constructor(
    private val dao: FavoriteMovieDao
) : IFavoriteMovieRepository {
    override suspend fun getFavorites(): List<MovieEntity> {
        return dao.getFavorites().map { it.toDomainEntity() }
    }

    override suspend fun addFavorite(movie: MovieEntity) {
        dao.addFavorite(movie.toRoomEntity())
    }

    override suspend fun removeFavorite(movie: MovieEntity) {
        dao.removeFavorite(movie.toRoomEntity())
    }

    override suspend fun isFavorite(movieId: Long): Boolean {
        return dao.isFavorite(movieId)
    }
}