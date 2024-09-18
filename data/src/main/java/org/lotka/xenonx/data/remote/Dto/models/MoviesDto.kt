package org.lotka.xenonx.data.remote.Dto.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import org.lotka.xenonx.domain.models.Movies

@Parcelize
data class MoviesDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("genres")
    val genres: List<GenreDto>?,
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String?,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("release_date", alternate = ["first_air_date"])
    val releaseDate: String,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("title", alternate = ["name"])
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) : Parcelable

fun MoviesDto.toMovie(): Movies {
    return Movies(
        adult = this.adult,
        backdropPath = this.backdropPath,
        posterPath = this.posterPath,
        genreIds = this.genreIds,
        genres = this.genres?.map { it.toGenre() }, // Assuming you have a toGenre() function
        mediaType = this.mediaType,
        id = this.id,
        imdbId = this.imdbId,
        originalLanguage = this.originalLanguage,
        overview = this.overview,
        popularity = this.popularity,
        releaseDate = this.releaseDate,
        runtime = this.runtime,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}

