package org.lotka.xenonx.presentation.screens.home

import org.lotka.xenonx.domain.models.Genre
import org.lotka.xenonx.domain.models.Movies

data class HomeState(
    val isLoading: Boolean = false,
    val movies: List<Movies> = emptyList(),
    val error: String = "",
    val endReached: Boolean = false,
    val genre : List<Genre> = emptyList(),
    val page: Int = 1
)
