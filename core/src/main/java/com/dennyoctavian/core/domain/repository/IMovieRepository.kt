package com.dennyoctavian.core.domain.repository

import com.dennyoctavian.core.domain.models.MovieDetailEntity
import com.dennyoctavian.core.domain.models.MovieEntity

interface IMovieRepository {
    suspend fun getMovies(): List<MovieEntity>
    suspend fun getDetailMovie(id: Long): MovieDetailEntity
}