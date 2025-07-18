package com.dennyoctavian.core.presentation.di

import com.dennyoctavian.core.domain.usecases.GetFavoritesUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun getFavoriteMoviesUseCase(): GetFavoritesUseCase
}
