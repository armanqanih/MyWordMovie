package org.lotka.xenonx.data.remote.repository


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import org.lotka.xenonx.data.local.MovieDatabase
import org.lotka.xenonx.data.local.toWatchListEntity
import org.lotka.xenonx.domain.models.WatchListModel
import org.lotka.xenonx.domain.repository.BookMarkRepository
import javax.inject.Inject

class BookMarkRepositoryImpl @Inject constructor(
    private val db: MovieDatabase
): BookMarkRepository {

    override suspend fun insertMovieInList(watchListModel: WatchListModel) {
       db.movieDao().insertMovieInList(watchListModel.toWatchListEntity())
    }

    override suspend fun removeFromList(id: Int) {
        db.movieDao().removeFromList(id)
    }

    override fun getAllWatchListData(): Flow<List<WatchListModel>> {
       return flow {
        db.movieDao().getAllWatchListData()
       }
    }

    override suspend fun deleteList() {
        db.movieDao().deleteList()
    }

    override suspend fun exists(mediaId: Int): Int {
       return db.movieDao().exists(mediaId)
    }


}