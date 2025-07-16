package com.dennyoctavian.core.data.datasource.internet

import com.dennyoctavian.core.domain.models.MovieDetailEntity
import com.dennyoctavian.core.domain.models.MovieEntity

interface IMovieDataSource {
    suspend fun getMovies() : List<MovieEntity>
    suspend fun getMovie(id: Long) : MovieDetailEntity
}