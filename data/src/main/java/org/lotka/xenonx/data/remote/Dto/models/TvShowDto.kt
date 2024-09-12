package org.lotka.xenonx.data.remote.Dto.models

import android.os.Parcelable
import org.lotka.xenonx.domain.models.ProductionCompany
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import org.lotka.xenonx.domain.models.Genre
import org.lotka.xenonx.domain.models.GenreDto

@Parcelize
data class TvShowDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("genres")
    val genres: List<GenreDto>?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyDto>?,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
): Parcelable
