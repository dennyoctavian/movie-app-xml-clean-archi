package com.dennyoctavian.movieappcleanarchitecture.data.models

import com.dennyoctavian.movieappcleanarchitecture.domain.models.*
import com.google.gson.annotations.SerializedName

data class DetailMovieResponse(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollection,
    val budget: Long,
    val genres: List<Genre>,
    val homepage: String,
    val id: Long,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Long,
    val runtime: Long,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
)

data class BelongsToCollection(
    val id: Long,
    val name: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
)

data class Genre(
    val id: Long,
    val name: String,
)

data class ProductionCompany(
    val id: Long,
    @SerializedName("logo_path")
    val logoPath: String?,
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String,
)

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val iso31661: String,
    val name: String,
)

data class SpokenLanguage(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("iso_639_1")
    val iso6391: String,
    val name: String,
)

fun BelongsToCollection?.toBelongsToCollectionEntity(): BelongsToCollectionEntity? {
    return this?.let {
        BelongsToCollectionEntity(
            id = it.id,
            name = it.name,
            posterPath = it.posterPath,
            backdropPath = it.backdropPath
        )
    }
}

fun Genre.toGenreEntity(): GenreEntity {
    return GenreEntity(
        id = this.id,
        name = this.name
    )
}

fun ProductionCompany.toProductionCompanyEntity(): ProductionCompanyEntity {
    return ProductionCompanyEntity(
        id = this.id,
        logoPath = this.logoPath,
        name = this.name,
        originCountry = this.originCountry
    )
}

fun ProductionCountry.toProductionCountryEntity(): ProductionCountryEntity {
    return ProductionCountryEntity(
        iso31661 = this.iso31661,
        name = this.name
    )
}

fun SpokenLanguage.toSpokenLanguageEntity(): SpokenLanguageEntity {
    return SpokenLanguageEntity(
        englishName = this.englishName,
        iso6391 = this.iso6391,
        name = this.name
    )
}

fun DetailMovieResponse.toMovieDetailEntity(): MovieDetailEntity {
    return MovieDetailEntity(
        adult = this.adult,
        backdropPath = this.backdropPath,
        belongsToCollection = this.belongsToCollection.toBelongsToCollectionEntity(),
        budget = this.budget,
        genres = this.genres.map { it.toGenreEntity() },
        homepage = this.homepage,
        id = this.id,
        imdbId = this.imdbId,
        originCountry = this.originCountry,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        productionCompanies = this.productionCompanies.map { it.toProductionCompanyEntity() },
        productionCountries = this.productionCountries.map { it.toProductionCountryEntity() },
        releaseDate = this.releaseDate,
        revenue = this.revenue,
        runtime = this.runtime,
        spokenLanguages = this.spokenLanguages.map { it.toSpokenLanguageEntity() },
        status = this.status,
        tagline = this.tagline,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}
