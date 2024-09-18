package org.lotka.xenonx.domain.usecase.home

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.repository.HomeRepository
import javax.inject.Inject

class GetAllMoviesWithPaginationUseCase @Inject constructor(
    private val movieRepository: HomeRepository
) {
    operator fun invoke(tags: String): Flow<PagingData<Movies>> {
        return movieRepository.getAllMoviesPagination(tags)
    }
}
