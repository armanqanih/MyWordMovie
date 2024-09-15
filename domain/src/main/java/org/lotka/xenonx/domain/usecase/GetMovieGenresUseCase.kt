package org.lotka.xenonx.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Genre
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

class GetMovieGenresUseCase@Inject constructor(
    private val movieRepository: HomeRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Genre>>> {
        return movieRepository.getMovieGenresRepo()
    }
}
