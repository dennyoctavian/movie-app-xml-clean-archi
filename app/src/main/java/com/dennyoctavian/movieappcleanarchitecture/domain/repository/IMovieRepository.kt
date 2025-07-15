package com.dennyoctavian.movieappcleanarchitecture.domain.repository

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieDetailEntity
import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity

interface IMovieRepository {
    suspend fun getMovies(): List<MovieEntity>
    suspend fun getDetailMovie(id: Long): MovieDetailEntity
}