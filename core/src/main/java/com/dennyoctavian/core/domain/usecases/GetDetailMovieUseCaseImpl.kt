package com.dennyoctavian.core.domain.usecases

import com.dennyoctavian.core.domain.models.MovieDetailEntity
import com.dennyoctavian.core.domain.repository.IMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetDetailMovieUseCaseImpl @Inject constructor(private val repository: IMovieRepository):
    com.dennyoctavian.core.domain.usecases.GetDetailMovieUseCase {
    override suspend fun getDetailMovie(id: Long): MovieDetailEntity {
        return repository.getDetailMovie(id)
    }
}