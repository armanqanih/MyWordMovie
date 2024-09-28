package org.lotka.xenonx.domain.usecase.boomark

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.models.WatchListModel
import org.lotka.xenonx.domain.repository.BookMarkRepository
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

class GetAllWatchListUseCase @Inject constructor(
    private val bookMarkRepository: BookMarkRepository
) {
      operator fun invoke(): Flow<List<WatchListModel>>{
        return bookMarkRepository.getAllWatchListData()
}}
