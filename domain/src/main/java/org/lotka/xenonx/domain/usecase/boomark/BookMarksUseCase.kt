package org.lotka.xenonx.domain.usecase.boomark

import javax.inject.Inject

class BookMarksUseCase@Inject constructor (
    val deleterListUseCase: DeleterListUseCase,
    val getAllWatchListUseCase: GetAllWatchListUseCase,
    val insertMoviesUseCase: InsertMoviesUseCase,
    val removeMovieFromListUseCase: RemoveMovieFromListUseCase,
    val existsUseCase: ExistsUseCase
)