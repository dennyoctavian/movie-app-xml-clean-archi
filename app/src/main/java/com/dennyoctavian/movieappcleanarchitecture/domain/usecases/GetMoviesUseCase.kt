package com.dennyoctavian.movieappcleanarchitecture.domain.usecases

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity

interface GetMoviesUseCase {
   suspend fun getMovies(): List<MovieEntity>
}