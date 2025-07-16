package com.dennyoctavian.core.presentation.di

import com.dennyoctavian.core.data.datasource.internet.IMovieDataSource
import com.dennyoctavian.core.data.datasource.internet.MovieDataSourceImpl
import com.dennyoctavian.core.data.remote.MovieService
import com.dennyoctavian.core.data.repository.MovieRepository
import com.dennyoctavian.core.domain.repository.IMovieRepository
import com.dennyoctavian.core.domain.usecases.GetMoviesUseCase
import com.dennyoctavian.core.domain.usecases.GetMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object MovieModule {
    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieDataSource(movieService: MovieService): IMovieDataSource {
        return MovieDataSourceImpl(movieService)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(movieDataSource: IMovieDataSource): IMovieRepository {
        return MovieRepository(movieDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMovieUseCase(movieRepository: IMovieRepository): GetMoviesUseCase {
        return GetMoviesUseCaseImpl(movieRepository)
    }
}
