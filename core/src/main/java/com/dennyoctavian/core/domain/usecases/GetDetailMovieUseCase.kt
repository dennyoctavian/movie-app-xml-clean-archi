package com.dennyoctavian.core.domain.usecases

import com.dennyoctavian.core.domain.models.MovieDetailEntity

interface GetDetailMovieUseCase {
   suspend  fun getDetailMovie(id: Long): MovieDetailEntity
}