package org.lotka.xenonx.presentation.screens.search

sealed class SearchEvent {
    data class UpdateSearchQuery(val query: String) : SearchEvent()
    object SearchMovies : SearchEvent()
    object LoadMorePosts : SearchEvent()
    object LoadedPage : SearchEvent()

}