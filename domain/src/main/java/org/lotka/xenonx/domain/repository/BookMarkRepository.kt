package org.lotka.xenonx.domain.repository

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.WatchListModel

interface BookMarkRepository {

    suspend fun insertMovieInList(watchListModel: WatchListModel)
    suspend fun removeFromList(id: Int)
    fun getAllWatchListData(): Flow<List<WatchListModel>>
    suspend fun deleteList()
    suspend fun exists(mediaId: Int): Int


}