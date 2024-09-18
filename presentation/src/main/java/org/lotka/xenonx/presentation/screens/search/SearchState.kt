package org.lotka.xenonx.presentation.screens.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

import org.lotka.xenonx.domain.models.Search

data class SearchState(
    var searchQuery: String = "",
    var multiSearchState: Flow<PagingData<Search>> = emptyFlow(),
    val isLoadingFirstTime: Boolean = true,
    val isLoadingNewPosts: Boolean = false,
    val error: String? = null,
    var searchActive : Boolean = false
    )
