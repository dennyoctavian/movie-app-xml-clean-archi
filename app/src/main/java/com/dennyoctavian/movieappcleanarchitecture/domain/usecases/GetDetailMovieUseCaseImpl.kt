package com.dennyoctavian.movieappcleanarchitecture.domain.usecases

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieDetailEntity
import com.dennyoctavian.movieappcleanarchitecture.domain.repository.IMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetDetailMovieUseCaseImpl @Inject constructor(private val repository: IMovieRepository): GetDetailMovieUseCase {
    override suspend fun getDetailMovie(id: Long): MovieDetailEntity {
        return repository.getDetailMovie(id)
    }
}