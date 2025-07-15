package com.dennyoctavian.movieappcleanarchitecture.domain.usecases

import com.dennyoctavian.movieappcleanarchitecture.domain.models.MovieEntity
import com.dennyoctavian.movieappcleanarchitecture.domain.repository.IMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMoviesUseCaseImpl @Inject constructor(private val repository: IMovieRepository): GetMoviesUseCase {
    override suspend fun getMovies(): List<MovieEntity> {
        return repository.getMovies()
    }
}