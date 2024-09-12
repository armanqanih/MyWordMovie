package org.lotka.xenonx.domain.models


import org.lotka.xenonx.domain.models.Genre


data class Movies(

    val adult: Boolean,

    val backdropPath: String?,

    val posterPath: String?,

    val genreIds: List<Int>?,

    val genres: List<Genre>?,

    val mediaType: String?,

    val id: Int,

    val imdbId: String?,

    val originalLanguage: String,

    val overview: String,

    val popularity: Double,

    val releaseDate: String,

    val runtime: Int?,

    val title: String,

    val video: Boolean,

    val voteAverage: Double,

    val voteCount: Int
)
