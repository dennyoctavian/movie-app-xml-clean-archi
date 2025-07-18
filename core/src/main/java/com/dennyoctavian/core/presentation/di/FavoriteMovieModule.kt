package com.dennyoctavian.core.presentation.di

import android.content.Context
import androidx.room.Room
import com.dennyoctavian.core.data.datasource.local.FavoriteMovieDao
import com.dennyoctavian.core.data.datasource.local.MovieDatabase
import com.dennyoctavian.core.data.repository.FavoriteMovieRepository
import com.dennyoctavian.core.domain.repository.IFavoriteMovieRepository
import com.dennyoctavian.core.domain.usecases.AddFavoritesUseCase
import com.dennyoctavian.core.domain.usecases.AddFavoritesUseCaseImpl
import com.dennyoctavian.core.domain.usecases.CheckFavoriteUseCase
import com.dennyoctavian.core.domain.usecases.CheckFavoriteUseCaseImpl
import com.dennyoctavian.core.domain.usecases.GetFavoritesUseCase
import com.dennyoctavian.core.domain.usecases.GetFavoritesUseCaseImpl
import com.dennyoctavian.core.domain.usecases.RemoveFavoritesUseCase
import com.dennyoctavian.core.domain.usecases.RemoveFavoritesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
@InstallIn(SingletonComponent::class)
@Module
object FavoriteMovieModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("admin123".toCharArray())
        val factory = SupportFactory(passphrase)

        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "encrypted_movie.db"
        )
            .openHelperFactory(factory)
            .fallbackToDestructiveMigration()
            .build()
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
}
