package org.lotka.xenonx.data.remote.response

import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.data.remote.Dto.models.GenreDto
import org.lotka.xenonx.domain.models.Genre
import org.lotka.xenonx.domain.response.MovieDetails


data class MovieDetailsDTO(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollectionDto?,
    @SerializedName("budget")
    val budget: Long,
    @SerializedName("genres")
    val genres: List<GenreDto>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyDto>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryDto>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("revenue")
    val revenue: Long,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageDto>,
    @SerializedName("status")
    val status: String,
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
) {

    
    data class BelongsToCollectionDto(
        @SerializedName("backdrop_path")
        val backdropPath: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("poster_path")
        val posterPath: String
    )

    
    data class ProductionCompanyDto(
        @SerializedName("id")
        val id: Int,
        @SerializedName("logo_path")
        val logoPath: String?,
        @SerializedName("name")
        val name: String,
        @SerializedName("origin_country")
        val originCountry: String
    )

    
    data class ProductionCountryDto(
        @SerializedName("iso_3166_1")
        val iso31661: String,
        @SerializedName("name")
        val name: String
    )

    
    data class SpokenLanguageDto(
        @SerializedName("iso_639_1")
        val iso6391: String,
        @SerializedName("name")
        val name: String
    )
}

fun MovieDetailsDTO.toMovieDetail(): MovieDetails {
    return MovieDetails(
        id = this.id,
        title = this.title,
        overview = this.overview,
        genres = this.genres.map { genreDto ->
            Genre(id = genreDto.id, name = genreDto.name)
        },
        runtime = this.runtime,
        voteAverage = this.voteAverage,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        budget = this.budget,
        revenue = this.revenue,
        adult = this.adult,
        backdropPath = this.backdropPath,
        belongsToCollection = this.belongsToCollection?.let {
            MovieDetails.BelongsToCollection(
                id = it.id,
                name = it.name,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath
            )
        },
        homepage = this.homepage,
        imdbId = this.imdbId,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        popularity = this.popularity,
        productionCompanies = this.productionCompanies.map { companyDto ->
            MovieDetails.ProductionCompany(
                id = companyDto.id,
                name = companyDto.name,
                logoPath = companyDto.logoPath,
                originCountry = companyDto.originCountry
            )
        },
        productionCountries = this.productionCountries.map { countryDto ->
            MovieDetails.ProductionCountry(
                iso31661 = countryDto.iso31661,
                name = countryDto.name
            )
        },
        spokenLanguages = this.spokenLanguages.map { languageDto ->
            MovieDetails.SpokenLanguage(
                iso6391 = languageDto.iso6391,
                name = languageDto.name
            )
        },
        status = this.status,
        tagline = this.tagline,
        video = this.video,
        voteCount = this.voteCount
    )
}


