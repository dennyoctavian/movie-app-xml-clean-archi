package com.dennyoctavian.core.data.repository

import com.dennyoctavian.core.data.datasource.internet.IMovieDataSource
import com.dennyoctavian.core.domain.models.MovieDetailEntity
import com.dennyoctavian.core.domain.models.MovieEntity
import com.dennyoctavian.core.domain.repository.IMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieDataSource: IMovieDataSource) :
    IMovieRepository {
    override suspend fun getMovies(): List<MovieEntity> = movieDataSource.getMovies()
    override suspend fun getDetailMovie(id: Long): MovieDetailEntity = movieDataSource.getMovie(id)
}