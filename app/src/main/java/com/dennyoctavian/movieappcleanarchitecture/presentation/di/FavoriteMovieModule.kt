package com.dennyoctavian.movieappcleanarchitecture.presentation.di

import android.content.Context
import androidx.room.Room
import com.dennyoctavian.movieappcleanarchitecture.data.datasource.local.FavoriteMovieDao
import com.dennyoctavian.movieappcleanarchitecture.data.datasource.local.MovieDatabase
import com.dennyoctavian.movieappcleanarchitecture.data.repository.FavoriteMovieRepository
import com.dennyoctavian.movieappcleanarchitecture.domain.repository.IFavoriteMovieRepository
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.AddFavoritesUseCase
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.AddFavoritesUseCaseImpl
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.CheckFavoriteUseCase
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.CheckFavoriteUseCaseImpl
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.GetFavoritesUseCase
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.GetFavoritesUseCaseImpl
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.RemoveFavoritesUseCase
import com.dennyoctavian.movieappcleanarchitecture.domain.usecases.RemoveFavoritesUseCaseImpl
import com.dennyoctavian.movieappcleanarchitecture.presentation.viewmodels.FavoriteViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FavoriteMovieModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movie_database"
        ).build()
    }

    @Provides
    fun provideFavoriteMovieDao(db: MovieDatabase): FavoriteMovieDao {
        return db.favoriteMovieDao()
    }

    @Provides
    @Singleton
    fun provideFavoriteMovieRepository(dao: FavoriteMovieDao): IFavoriteMovieRepository {
        return FavoriteMovieRepository(dao)
    }

    @Provides
    @Singleton
    fun provideAddFavoritesUseCase(favoriteRepository: IFavoriteMovieRepository): AddFavoritesUseCase {
        return AddFavoritesUseCaseImpl(favoriteRepository)
    }

    @Provides
    @Singleton
    fun provideGetFavoritesUseCase(favoriteRepository: IFavoriteMovieRepository): GetFavoritesUseCase {
        return GetFavoritesUseCaseImpl(favoriteRepository)
    }

    @Provides
    @Singleton
    fun provideRemoveFavoritesUseCase(favoriteRepository: IFavoriteMovieRepository): RemoveFavoritesUseCase {
        return RemoveFavoritesUseCaseImpl(favoriteRepository)
    }

    @Provides
    @Singleton
    fun provideCheckFavoriteUseCase(favoriteRepository: IFavoriteMovieRepository): CheckFavoriteUseCase {
        return CheckFavoriteUseCaseImpl(favoriteRepository)
    }

    @Provides
    @Singleton
    fun provideFavoriteViewModel(getFavoritesUseCase: GetFavoritesUseCase) : FavoriteViewModel {
        return FavoriteViewModel(getFavoritesUseCase)
    }

}