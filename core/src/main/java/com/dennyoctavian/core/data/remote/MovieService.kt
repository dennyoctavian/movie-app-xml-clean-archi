package com.dennyoctavian.core.data.remote

import com.dennyoctavian.core.data.models.DetailMovieResponse
import com.dennyoctavian.core.data.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("now_playing")
    suspend fun getPopularMovies(): MovieResponse

    @GET("{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") id: Long,
    ): DetailMovieResponse
}