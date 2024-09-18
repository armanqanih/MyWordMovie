package org.lotka.xenonx.presentation.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.filter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.lotka.xenonx.domain.usecase.search.SearchUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state = _state.asStateFlow()

    private var searchJob: Job? = null


    init {
        state.value.searchQuery = ""
        searchRemoteMovie(true)
    }

    fun onEvent(event: SearchEvent) {
        when(event){
            SearchEvent.LoadMorePosts -> {
                _state.value = _state.value.copy(
                    isLoadingNewPosts = true
                )
            }
            SearchEvent.LoadedPage -> {
                _state.value = _state.value.copy(
                    isLoadingFirstTime = false,
                    isLoadingNewPosts = false
                )
            }
            SearchEvent.SearchMovies -> TODO()
            is SearchEvent.UpdateSearchQuery -> TODO()
        }
    }



    fun searchRemoteMovie(includeAdult: Boolean) {
        viewModelScope.launch {
            if (state.value.searchQuery.isNotEmpty()) {
                state.value.multiSearchState = searchUseCase.invoke(
                    searchQuery = state.value.searchQuery,
                    includeAdult
                ).map { result ->
                    result.filter {
                        ((it.title != null || it.originalName != null || it.originalTitle != null)) }
                }.cachedIn(viewModelScope)
            }
        }
    }




}