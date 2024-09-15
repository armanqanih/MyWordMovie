package org.lotka.xenonx.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.repository.HomeRepository
import javax.inject.Inject

class GetMoviesByGenreUseCase @Inject constructor(
    private val movieRepository: HomeRepository
) {
   operator fun invoke(genreId: Int): Flow<PagingData<List<Movies>>> {
        return movieRepository.getGenresWiseMovieRepo(genreId)
    }
}
