package com.dennyoctavian.movieappcleanarchitecture.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailEntity(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: BelongsToCollectionEntity?,
    val budget: Long,
    val genres: List<GenreEntity>,
    val homepage: String,
    val id: Long,
    val imdbId: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyEntity>,
    val productionCountries: List<ProductionCountryEntity>,
    val releaseDate: String,
    val revenue: Long,
    val runtime: Long,
    val spokenLanguages: List<SpokenLanguageEntity>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Long,
): Parcelable

@Parcelize
data class BelongsToCollectionEntity(
    val id: Long,
    val name: String,
    val posterPath: String,
    val backdropPath: String,
): Parcelable

@Parcelize
data class GenreEntity(
    val id: Long,
    val name: String,
): Parcelable

@Parcelize
data class ProductionCompanyEntity(
    val id: Long,
    val logoPath: String?,
    val name: String,
    val originCountry: String,
): Parcelable

@Parcelize
data class ProductionCountryEntity(
    val iso31661: String,
    val name: String,
): Parcelable

@Parcelize
data class SpokenLanguageEntity(
    val englishName: String,
    val iso6391: String,
    val name: String,
): Parcelable
