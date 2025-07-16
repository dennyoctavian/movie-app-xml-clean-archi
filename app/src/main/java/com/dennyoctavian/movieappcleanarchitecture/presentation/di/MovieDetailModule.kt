package com.dennyoctavian.movieappcleanarchitecture.presentation.di

import com.dennyoctavian.movieappcleanarchitecture.domain.repository.IMovieRepository
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.AddFavoritesUseCase
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.CheckFavoriteUseCase
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.GetDetailMovieUseCase
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.GetDetailMovieUseCaseImpl
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.RemoveFavoritesUseCase
import com.dennyoctavian.movieappcleanarchitecture.presentation.viewmodels.DetailMovieViewModel
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
