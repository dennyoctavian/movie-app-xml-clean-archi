package com.dennyoctavian.movieappcleanarchitecture.data.remote

import com.dennyoctavian.movieappcleanarchitecture.data.models.DetailMovieResponse
import com.dennyoctavian.movieappcleanarchitecture.data.models.MovieResponse
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