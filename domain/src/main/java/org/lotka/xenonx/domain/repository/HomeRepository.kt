package org.lotka.xenonx.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Genre
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.util.Resource

interface HomeRepository {

    suspend fun getNowPlayingMovies(page:Int): Flow<Resource<Movies>>

    suspend fun getPopularMovies(): Flow<Resource<Movies>>

    suspend fun getDiscoverMoviesRepo(): Flow<Resource<Movies>>


    fun getAllMoviesPagination(tags: String):Flow<PagingData<Movies>>

    fun getGenresWiseMovieRepo(tags: Int):Flow<PagingData<Movies>>


    fun getTrendingMoviesRepo(): Flow<Resource<Movies>>

    fun getUpcomingMoviesRepo(): Flow<Resource<Movies>>

    fun getMovieGenresRepo(): Flow<Resource<Genre>>


}