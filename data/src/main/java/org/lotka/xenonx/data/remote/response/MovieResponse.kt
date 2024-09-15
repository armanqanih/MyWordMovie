package com.app.movieapp.data.remote.response

import org.lotka.xenonx.domain.models.Movies
import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.data.remote.Dto.models.MoviesDto

data class MovieResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
     val results: List<MoviesDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
