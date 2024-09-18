package org.lotka.xenonx.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lotka.xenonx.data.remote.api.ApiService
import org.lotka.xenonx.data.remote.pagination.SearchPagingSource
import org.lotka.xenonx.domain.models.Search
import org.lotka.xenonx.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
   val api:ApiService
):SearchRepository{
    override suspend fun multiSearch(searchQuery: String, includeAdult: Boolean): Flow<PagingData<Search>> {
        return flow {
            Pager(
                config = PagingConfig(enablePlaceholders = false, pageSize = 20),
                pagingSourceFactory = {
                    SearchPagingSource(api = api, searchParams = searchQuery, includeAdult)
                }
            )
        }

    }


}