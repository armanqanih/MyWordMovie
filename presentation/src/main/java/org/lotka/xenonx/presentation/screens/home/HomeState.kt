package org.lotka.xenonx.presentation.screens.home

import org.lotka.xenonx.domain.models.Genre
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.response.GenreResponse
import org.lotka.xenonx.domain.response.MovieResponse

data class HomeState(
    val isLoading: Boolean = false,
    val nowPlayingMovies:List<Movies>? = emptyList(),
    val popularMovies:   List<Movies>? = emptyList(),
    val discoverMovies:  List<Movies>? = emptyList(),
    val movies:  List<Movies>? = emptyList(),
    val trendingMovies:  List<Movies>? = emptyList(),
    val upcomingMovies:  List<Movies>? = emptyList(),
    val genre: List<Genre>? = emptyList(),
    val error: String = "",
    val endReached: Boolean = false,
    val page: Int = 1
)
