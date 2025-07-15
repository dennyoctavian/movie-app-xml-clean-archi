package com.dennyoctavian.movieappcleanarchitecture.data.datasource.internet

import android.util.Log
import com.dennyoctavian.movieappcleanarchitecture.data.models.toMovieDetailEntity
import com.dennyoctavian.movieappcleanarchitecture.data.models.toMovieEntity
import com.dennyoctavian.movieappcleanarchitecture.data.remote.MovieService
import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieDetailEntity
import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(
    private val movieService: MovieService
) : IMovieDataSource {

    override suspend fun getMovies(): List<MovieEntity> {
        val response = movieService.getPopularMovies()
        Log.d("Response API", "getMovies: ${response.results}")
        return response.results.map { it.toMovieEntity() }
    }

    override suspend fun getMovie(id: Long): MovieDetailEntity {
        val detail = movieService.getMovieDetail(id)
        return detail.toMovieDetailEntity()
    }
}