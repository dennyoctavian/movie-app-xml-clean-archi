package com.dennyoctavian.core.presentation.di

import com.dennyoctavian.core.domain.repository.IMovieRepository
import com.dennyoctavian.core.domain.usecases.GetDetailMovieUseCase
import com.dennyoctavian.core.domain.usecases.GetDetailMovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MovieDetailModule {
    @Provides
    @Singleton
    fun provideGetMovieDetailUseCase(movieRepository: IMovieRepository): GetDetailMovieUseCase {
        return GetDetailMovieUseCaseImpl(movieRepository)
    }
}
