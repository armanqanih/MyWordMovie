package org.lotka.xenonx.domain.usecase.detail

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.repository.DetailRepository
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.response.CastResponse
import org.lotka.xenonx.domain.response.MovieDetails
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

class GetSimilarMovieUseCase @Inject constructor(
    private val repository: DetailRepository
) {
     operator fun invoke(movieId: String): Flow<Resource<List<Movies>>> {
        return repository.getSimilarMoviesRepo(movieId)
    }
}
