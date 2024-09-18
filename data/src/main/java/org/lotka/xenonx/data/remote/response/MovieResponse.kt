package org.lotka.xenonx.data.remote.response

import org.lotka.xenonx.domain.models.Movies
import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.data.remote.Dto.models.MoviesDto
import org.lotka.xenonx.data.remote.Dto.models.toMovie
import org.lotka.xenonx.domain.response.MovieResponse

data class MovieResponseDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
     val results: List<MoviesDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)


fun MovieResponseDto.toMovieResponse(): MovieResponse {
    return MovieResponse(
        page = page,
        results = results.map { it.toMovie() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}
