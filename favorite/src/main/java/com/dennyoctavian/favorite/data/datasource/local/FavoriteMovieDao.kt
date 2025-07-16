package com.dennyoctavian.favorite.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteMovieDao {
    @Query("SELECT * FROM favorite_movies")
    suspend fun getFavorites(): List<MovieEntityRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(movie: MovieEntityRoom)

    @Delete
    suspend fun removeFavorite(movie: MovieEntityRoom)

    @Query("SELECT COUNT(*) > 0 FROM favorite_movies WHERE id = :movieId")
    suspend fun isFavorite(movieId: Long): Boolean
}
