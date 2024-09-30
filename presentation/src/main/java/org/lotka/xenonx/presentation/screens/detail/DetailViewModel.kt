package org.lotka.xenonx.presentation.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.lotka.xenonx.domain.usecase.detail.DetailUseCases
import org.lotka.xenonx.domain.util.Resource
import org.lotka.xenonx.presentation.screens.home.HomeState
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val detailUseCases: DetailUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val _state = MutableStateFlow(DetailState())
    val state = _state.asStateFlow()


    init {
        savedStateHandle.get<String>("movieId")?.let { movieId ->
            fetchDetailMovie(movieId)
            fetchCastMovie(movieId)
            fetchSimilarMovie(movieId)
        }
    }



    fun fetchSimilarMovie(id: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            detailUseCases.getSimilarMovieUseCase(id).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            movies = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            error = result.message.toString()
                        )
                    }
                    is Resource.Loading -> _state.value = _state.value.copy(isLoading = true)
                }
            }
        }
    }


    fun fetchCastMovie(id: String) {
        viewModelScope.launch {
            detailUseCases.getCastMovieUseCase(id).collect { result ->
                _state.value = _state.value.copy(isLoading = true)
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            castList = result.data?.castResult ?: emptyList(),
                            isLoading = false
                        )
                    }

                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            error = result.message.toString()
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                }
            }


        }
    }


    fun fetchDetailMovie(id: String) {
        viewModelScope.launch {
            detailUseCases.getDetailMoviesUseCase(id).collect { result ->
                _state.value = _state.value.copy(isLoading = true)
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            movieDetail = result.data,
                            isLoading = false,
                        )

                    }

                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            error = result.message.toString()
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true,
                        )

                    }
                }
            }
        }
    }


}