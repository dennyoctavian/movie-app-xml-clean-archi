package com.dennyoctavian.core.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieEntityRoom::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun favoriteMovieDao(): FavoriteMovieDao
}