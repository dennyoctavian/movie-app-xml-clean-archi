package com.dennyoctavian.core.data.datasource.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dennyoctavian.core.domain.models.MovieEntity

@Entity(tableName = "favorite_movies")
data class MovieEntityRoom(
    @PrimaryKey val id: Long,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double
)

fun MovieEntity.toRoomEntity() = MovieEntityRoom(
    id = id,
    title = title,
    overview = overview,
    posterPath = posterPath,
    voteAverage = voteAverage
)

fun MovieEntityRoom.toDomainEntity() = MovieEntity(
    id = id,
    title = title,
    overview = overview,
    posterPath = posterPath,
    voteAverage = voteAverage,
    adult = false,
    backdropPath = "",
    genreIds = listOf(),
    originalLanguage = "",
    originalTitle = "",
    popularity = 0.0,
    releaseDate = "",
    video = false,
    voteCount = 0
)
