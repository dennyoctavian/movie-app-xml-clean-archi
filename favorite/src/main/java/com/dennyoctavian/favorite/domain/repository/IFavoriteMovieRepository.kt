package com.dennyoctavian.favorite.domain.repository

import com.dennyoctavian.core.domain.models.MovieEntity

interface IFavoriteMovieRepository {
    suspend fun getFavorites(): List<MovieEntity>
    suspend fun addFavorite(movie: MovieEntity)
    suspend fun removeFavorite(movie: MovieEntity)
    suspend fun isFavorite(movieId: Long): Boolean
}