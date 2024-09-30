package org.lotka.xenonx.presentation.screens.detail

import org.lotka.xenonx.domain.models.Cast
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.response.MovieDetails
import java.lang.Error

data class DetailState(
    val isLoading: Boolean = false,
    val movieDetail: MovieDetails? = null,
    val listOfMovieDetail: List<MovieDetails> = emptyList(),
    val castList: List<Cast> = emptyList(),
    val movies:List<Movies> = emptyList(),
    val error: String = "",

)
