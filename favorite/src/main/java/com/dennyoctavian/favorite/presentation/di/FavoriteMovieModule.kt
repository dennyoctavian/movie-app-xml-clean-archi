package com.dennyoctavian.favorite.presentation.di

import android.content.Context
import androidx.room.Room
import com.dennyoctavian.favorite.data.datasource.local.FavoriteMovieDao
import com.dennyoctavian.favorite.data.datasource.local.MovieDatabase
import com.dennyoctavian.favorite.domain.repository.IFavoriteMovieRepository
import com.dennyoctavian.favorite.domain.usecases.AddFavoritesUseCase
import com.dennyoctavian.favorite.domain.usecases.CheckFavoriteUseCase
import com.dennyoctavian.favorite.domain.usecases.GetFavoritesUseCase
import com.dennyoctavian.favorite.domain.usecases.RemoveFavoritesUseCase
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
        return com.dennyoctavian.favorite.data.repository.FavoriteMovieRepository(dao)
    }

    @Provides
    @Singleton
    fun provideAddFavoritesUseCase(favoriteRepository: IFavoriteMovieRepository): AddFavoritesUseCase {
        return com.dennyoctavian.favorite.domain.usecases.AddFavoritesUseCaseImpl(
            favoriteRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetFavoritesUseCase(favoriteRepository: IFavoriteMovieRepository): GetFavoritesUseCase {
        return com.dennyoctavian.favorite.domain.usecases.GetFavoritesUseCaseImpl(
            favoriteRepository
        )
    }

    @Provides
    @Singleton
    fun provideRemoveFavoritesUseCase(favoriteRepository: IFavoriteMovieRepository): RemoveFavoritesUseCase {
        return com.dennyoctavian.favorite.domain.usecases.RemoveFavoritesUseCaseImpl(
            favoriteRepository
        )
    }

    @Provides
    @Singleton
    fun provideCheckFavoriteUseCase(favoriteRepository: IFavoriteMovieRepository): CheckFavoriteUseCase {
        return com.dennyoctavian.favorite.domain.usecases.CheckFavoriteUseCaseImpl(
            favoriteRepository
        )
    }
}