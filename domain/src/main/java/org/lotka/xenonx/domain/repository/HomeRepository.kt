package org.lotka.xenonx.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Genre
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.response.GenreResponse
import org.lotka.xenonx.domain.response.MovieResponse
import org.lotka.xenonx.domain.util.Resource

interface HomeRepository {

    suspend fun getNowPlayingMovies(page:Int): Flow<Resource<List<Movies>>>

    suspend fun getPopularMovies(page:Int): Flow<Resource<List<Movies>>>

    suspend fun getDiscoverMoviesRepo(page:Int): Flow<Resource<List<Movies>>>


    fun getAllMoviesPagination(tags: String):Flow<PagingData<Movies>>

    fun getGenresWiseMovieRepo(tags: Int):Flow<PagingData<Movies>>


  suspend  fun getTrendingMoviesRepo(page:Int): Flow<Resource<List<Movies>>>

   suspend fun getUpcomingMoviesRepo(page:Int): Flow<Resource<List<Movies>>>

  suspend  fun getMovieGenresRepo(): Flow<Resource<List<Genre>>>


}