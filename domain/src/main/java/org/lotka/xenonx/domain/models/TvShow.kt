package org.lotka.xenonx.domain.models

data class TvShow(

    val adult: Boolean,

    val backdropPath: String?,

    val genreIds: List<Int>?,

    val genres: List<Genre>?,

    val id: Int,

    val imdbId: String?,

    val productionCompanies: List<ProductionCompany>?,

    val originalLanguage: String,

    val originalTitle: String,

    val overview: String,

    val popularity: Double,

    val posterPath: String?,

    val releaseDate: String,

    val runtime: Int,

    val title: String,

    val video: Boolean,

    val voteAverage: Double,

    val voteCount: Int
)