package com.dennyoctavian.movieappcleanarchitecture.data.models

import com.dennyoctavian.movieappcleanarchitecture.domain.models.*
import com.google.gson.annotations.SerializedName

data class DetailMovieResponse(
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollection?,
    val budget: Long?,
    val genres: List<Genre>?,
    val homepage: String?,
    val id: Long?,
    @SerializedName("imdb_id")
    val imdbId: String?,
    @SerializedName("origin_country")
    val originCountry: List<String>?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>?,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val revenue: Long?,
    val runtime: Long?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Long?,
)

data class BelongsToCollection(
    val id: Long?,
    val name: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
)

data class Genre(
    val id: Long?,
    val name: String?,
)

data class ProductionCompany(
    val id: Long?,
    @SerializedName("logo_path")
    val logoPath: String?,
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: String?,
)

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val iso31661: String?,
    val name: String?,
)

data class SpokenLanguage(
    @SerializedName("english_name")
    val englishName: String?,
    @SerializedName("iso_639_1")
    val iso6391: String?,
    val name: String?,
)

fun BelongsToCollection?.toBelongsToCollectionEntity(): BelongsToCollectionEntity? {
    return this?.let {
        BelongsToCollectionEntity(
            id = it.id ?: 0L,
            name = it.name.orEmpty(),
            posterPath = it.posterPath.orEmpty(),
            backdropPath = it.backdropPath.orEmpty()
        )
    }
}

fun Genre.toGenreEntity(): GenreEntity {
    return GenreEntity(
        id = this.id ?: 0L,
        name = this.name.orEmpty()
    )
}

fun ProductionCompany.toProductionCompanyEntity(): ProductionCompanyEntity {
    return ProductionCompanyEntity(
        id = this.id ?: 0L,
        logoPath = this.logoPath,
        name = this.name.orEmpty(),
        originCountry = this.originCountry.orEmpty()
    )
}

fun ProductionCountry.toProductionCountryEntity(): ProductionCountryEntity {
    return ProductionCountryEntity(
        iso31661 = this.iso31661.orEmpty(),
        name = this.name.orEmpty()
    )
}

fun SpokenLanguage.toSpokenLanguageEntity(): SpokenLanguageEntity {
    return SpokenLanguageEntity(
        englishName = this.englishName.orEmpty(),
        iso6391 = this.iso6391.orEmpty(),
        name = this.name.orEmpty()
    )
}

fun DetailMovieResponse.toMovieDetailEntity(): MovieDetailEntity {
    return MovieDetailEntity(
        adult = this.adult ?: false,
        backdropPath = this.backdropPath.orEmpty(),
        belongsToCollection = this.belongsToCollection.toBelongsToCollectionEntity(),
        budget = this.budget ?: 0L,
        genres = this.genres?.map { it.toGenreEntity() } ?: emptyList(),
        homepage = this.homepage.orEmpty(),
        id = this.id ?: 0L,
        imdbId = this.imdbId.orEmpty(),
        originCountry = this.originCountry ?: emptyList(),
        originalLanguage = this.originalLanguage.orEmpty(),
        originalTitle = this.originalTitle.orEmpty(),
        overview = this.overview.orEmpty(),
        popularity = this.popularity ?: 0.0,
        posterPath = this.posterPath.orEmpty(),
        productionCompanies = this.productionCompanies?.map { it.toProductionCompanyEntity() } ?: emptyList(),
        productionCountries = this.productionCountries?.map { it.toProductionCountryEntity() } ?: emptyList(),
        releaseDate = this.releaseDate.orEmpty(),
        revenue = this.revenue ?: 0L,
        runtime = this.runtime ?: 0L,
        spokenLanguages = this.spokenLanguages?.map { it.toSpokenLanguageEntity() } ?: emptyList(),
        status = this.status.orEmpty(),
        tagline = this.tagline.orEmpty(),
        title = this.title.orEmpty(),
        video = this.video ?: false,
        voteAverage = this.voteAverage ?: 0.0,
        voteCount = this.voteCount ?: 0L
    )
}
