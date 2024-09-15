package org.lotka.xenonx.data.remote.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState


import kotlinx.coroutines.delay
import org.lotka.xenonx.data.remote.api.ApiService
import org.lotka.xenonx.data.remote.Dto.models.MoviesDto
import org.lotka.xenonx.domain.util.Constants.Companion.discoverListScreen
import org.lotka.xenonx.domain.util.Constants.Companion.nowPlayingAllListScreen
import org.lotka.xenonx.domain.util.Constants.Companion.popularAllListScreen
import org.lotka.xenonx.domain.util.Constants.Companion.upcomingListScreen

class MoviePagingSource(
    private val apiService: ApiService,
    private val tags: String)
    : PagingSource<Int, MoviesDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesDto> {
        return try {
            val currentPage = params.key ?: 1
            // Simulate a delay for network calls (optional, can be removed in production)
            delay(3000L)
            // Fetch data from the appropriate API endpoint based on tags
            val response = when (tags) {
                nowPlayingAllListScreen -> apiService.getNowPlayingMovies(page = currentPage)
                discoverListScreen -> apiService.getDiscoverMovies(page = currentPage)
                upcomingListScreen -> apiService.getUpcomingMovies(page = currentPage)
                popularAllListScreen -> apiService.getPopularMovies(page = currentPage)
                else -> apiService.getPopularMovies(page = currentPage) // Default case
            }
            // Map MoviesDto to Movies using the `toMovie` extension function
           // Assuming `response.results` is a list of `MoviesDto`
            // Determine the next and previous page keys
            val nextKey =   currentPage + 1
            val prevKey = if (currentPage == 1) null else currentPage - 1
            // Return the loaded page of data
            LoadResult.Page(
                data = response,
                prevKey = prevKey,
                nextKey = nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MoviesDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
