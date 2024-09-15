package org.lotka.xenonx.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.usecase.HomeUseCases
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCases: HomeUseCases
) : ViewModel() {

    var genresWiseMovieListState: Flow<PagingData<List<Movies>>>? = null
    val nowPlayingAllListState = homeUseCases.getAllMoviesWithPaginationUseCase("nowPlayingAllListScreen").cachedIn(viewModelScope)
    val popularAllListState = homeUseCases.getAllMoviesWithPaginationUseCase("popularAllListScreen") .cachedIn(viewModelScope)
    val discoverListState = homeUseCases.getAllMoviesWithPaginationUseCase("discoverListScreen") .cachedIn(viewModelScope)
    val upcomingListState = homeUseCases.getAllMoviesWithPaginationUseCase("upcomingListScreen") .cachedIn(viewModelScope)

    fun setGenreData(genreSelected: Int) {
        genresWiseMovieListState=  homeUseCases.getGenresWiseMovieUseCase(genreSelected).cachedIn(viewModelScope)
    }





    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()
    val page = _state.value.page

    init {
        fetchNowPlayingMoviesUseCase()
        fetchPopularMoviesUseCase()
        fetchDiscoverMovies()
        fetchTrendingMoviesUseCase()
        fetchUpcomingMoviesUseCase()
    }














    fun fetchMovieGenresUseCase() {
        viewModelScope.launch {
            homeUseCases.getMovieGenresUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            genre = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                       _state.value = _state.value.copy(
                           isLoading = false,
                           error = result.message.toString()
                       )
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }

    fun fetchUpcomingMoviesUseCase() {
        viewModelScope.launch {
            homeUseCases.getUpcomingMoviesUseCase(page).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            movies = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = result.message.toString()
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }

    fun fetchTrendingMoviesUseCase() {
        viewModelScope.launch {
            homeUseCases.getTrendingMoviesUseCase(page).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            movies = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = result.message.toString()
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }

    fun fetchNowPlayingMoviesUseCase() {
        viewModelScope.launch {
            homeUseCases.getNowPlayingMoviesUseCase(page).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            movies = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = result.message.toString()
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }

    fun fetchDiscoverMovies() {
        viewModelScope.launch {
            homeUseCases.getDiscoverMoviesUseCase(page).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            movies = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = result.message.toString()
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }

    fun fetchPopularMoviesUseCase() {
        viewModelScope.launch {
            homeUseCases.getPopularMoviesUseCase(page).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            movies = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = result.message.toString()
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }
}
