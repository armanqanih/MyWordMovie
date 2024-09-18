package org.lotka.xenonx.domain.usecase.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.models.Search
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.repository.SearchRepository
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(searchQuery: String, includeAdult: Boolean): Flow<PagingData<Search>> {
        return repository.multiSearch(searchQuery,includeAdult)
    }
}
