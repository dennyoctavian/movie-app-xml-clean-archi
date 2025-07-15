package com.dennyoctavian.movieappcleanarchitecture.data.datasource.internet

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieDetailEntity
import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity

interface IMovieDataSource {
    suspend fun getMovies() : List<MovieEntity>
    suspend fun getMovie(id: Long) : MovieDetailEntity
}