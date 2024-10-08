package org.lotka.xenonx.domain.usecase.home

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

class GetPopularMoviesUseCase@Inject constructor(
    private val movieRepository: HomeRepository
) {
    suspend operator fun invoke(page: Int):  Flow<Resource<List<Movies>>> {
        return movieRepository.getPopularMovies(page)
    }
}
