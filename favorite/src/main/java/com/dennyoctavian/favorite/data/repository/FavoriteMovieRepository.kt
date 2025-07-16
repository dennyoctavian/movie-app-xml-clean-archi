package com.dennyoctavian.favorite.data.repository

import com.dennyoctavian.favorite.data.datasource.local.toDomainEntity
import com.dennyoctavian.favorite.data.datasource.local.toRoomEntity
import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.favorite.domain.repository.IFavoriteMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteMovieRepository @Inject constructor(
    private val dao: com.dennyoctavian.favorite.data.datasource.local.FavoriteMovieDao
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
