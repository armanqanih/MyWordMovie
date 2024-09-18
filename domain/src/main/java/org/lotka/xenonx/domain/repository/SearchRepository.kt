package org.lotka.xenonx.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Search

interface SearchRepository {
   suspend fun multiSearch(searchQuery: String, includeAdult: Boolean): Flow<PagingData<Search>>
}