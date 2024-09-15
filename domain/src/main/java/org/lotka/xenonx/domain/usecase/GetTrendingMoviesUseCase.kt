package org.lotka.xenonx.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

class GetTrendingMoviesUseCase@Inject constructor(
    private val movieRepository: HomeRepository
) {
    suspend operator fun invoke(page: Int): Flow<Resource<List<Movies>>> {
        return movieRepository.getTrendingMoviesRepo(page)
    }
}
