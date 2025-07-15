package com.dennyoctavian.movieappcleanarchitecture.data.repository

import com.dennyoctavian.movieappcleanarchitecture.data.datasource.internet.IMovieDataSource
import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieDetailEntity
import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity
import com.dennyoctavian.movieappcleanarchitecture.domain.repository.IMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieDataSource: IMovieDataSource) : IMovieRepository {
    override suspend fun getMovies(): List<MovieEntity> = movieDataSource.getMovies()
    override suspend fun getDetailMovie(id: Long): MovieDetailEntity = movieDataSource.getMovie(id)
}