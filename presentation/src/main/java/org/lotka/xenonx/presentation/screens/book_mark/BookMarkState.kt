package org.lotka.xenonx.presentation.screens.book_mark

import org.lotka.xenonx.domain.models.WatchListModel

data class BookMarkState(
    val isLoading: Boolean = false,
    val watchListMovies: List<WatchListModel> = emptyList(),
    val exist : Int = 0

)