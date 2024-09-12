package org.lotka.xenonx.domain.models




data class Search(

    val adult: Boolean?,

    val backdropPath: String?,

    val genreIds: List<Int>?,

    val genres: List<Genre>?,

    val id: Int?,

    val imdbId: String?,

    val mediaType: String?,

    val originCountry: List<String>?,

    val originalLanguage: String?,

    val originalName: String?,

    val originalTitle: String?,

    val overview: String?,

    val popularity: Double?,

    val posterPath: String?,

    val releaseDate: String?,

    val title: String?,

    val video: Boolean?,

    val runtime: Int?,

    val voteAverage: Double?,

    val voteCount: Int?
)
