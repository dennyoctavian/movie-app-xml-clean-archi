package com.dennyoctavian.core.domain.usecases

import com.dennyoctavian.core.domain.models.MovieEntity

interface GetMoviesUseCase {
   suspend fun getMovies(): List<MovieEntity>
}