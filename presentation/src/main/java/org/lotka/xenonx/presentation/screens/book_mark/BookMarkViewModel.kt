package org.lotka.xenonx.presentation.screens.book_mark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.lotka.xenonx.domain.models.WatchListModel
import org.lotka.xenonx.domain.usecase.boomark.BookMarksUseCase
import org.lotka.xenonx.presentation.util.UiEvent
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val bookMarkUseCases: BookMarksUseCase
): ViewModel()  {

    private val _state = MutableStateFlow(BookMarkState())
    val state = _state.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<UiEvent>()
    val sharedFlow = _sharedFlow.asSharedFlow()




   init {
     getAllWatchList()
   }



    fun getAllWatchList() {
        viewModelScope.launch {
        bookMarkUseCases.getAllWatchListUseCase().collect{ watchListMovies ->
            _state.value = _state.value.copy(
                watchListMovies = watchListMovies
            )
        }

        }
    }

    fun addToBookMark(movie: WatchListModel){
        viewModelScope.launch {
            bookMarkUseCases.insertMoviesUseCase(movie)
            _sharedFlow.emit(UiEvent.ShowSnakeBar("Added To BookMark"))
        }.invokeOnCompletion {
            exists(id = movie.mediaId)

        }
    }

    fun removeFromList(id: Int) {
        viewModelScope.launch {
            bookMarkUseCases.removeMovieFromListUseCase(id)
            _sharedFlow.emit(UiEvent.ShowSnakeBar("Remove In BookMark"))
        }.invokeOnCompletion {
            exists(id = id)
        }
    }

    fun deleteList() {
        viewModelScope.launch {
            bookMarkUseCases.deleterListUseCase()
        }
    }


    fun exists(id: Int) {
        viewModelScope.launch {
            bookMarkUseCases.existsUseCase(id)
        }
    }


}













