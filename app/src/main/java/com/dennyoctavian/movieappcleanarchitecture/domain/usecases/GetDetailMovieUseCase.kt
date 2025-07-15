package com.dennyoctavian.movieappcleanarchitecture.domain.usecases

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieDetailEntity

interface GetDetailMovieUseCase {
   suspend  fun getDetailMovie(id: Long): MovieDetailEntity
}