package com.dennyoctavian.core.data.datasource.internet

import android.util.Log
import com.dennyoctavian.core.data.models.toMovieDetailEntity
import com.dennyoctavian.core.data.models.toMovieEntity
import com.dennyoctavian.core.data.remote.MovieService
import com.dennyoctavian.core.domain.models.MovieDetailEntity
import com.dennyoctavian.core.domain.models.MovieEntity
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