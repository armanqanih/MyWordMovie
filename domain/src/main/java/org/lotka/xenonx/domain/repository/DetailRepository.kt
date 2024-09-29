package org.lotka.xenonx.domain.repository

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.response.CastResponse
import org.lotka.xenonx.domain.response.MovieDetails
import org.lotka.xenonx.domain.util.Resource

interface DetailRepository {

    fun getMoviesDetails(movieId: String): Flow<Resource<MovieDetails>>

    fun getCastMoviesRepo(movieId: String): Flow<Resource<CastResponse>>

    fun getSimilarMoviesRepo(movieId: String): Flow<Resource<List<Movies>>>
}