package org.lotka.xenonx.data.remote.pagination


import androidx.paging.PagingSource
import androidx.paging.PagingState

import kotlinx.coroutines.delay
import org.lotka.xenonx.data.remote.api.ApiService
import org.lotka.xenonx.data.remote.Dto.models.MoviesDto

class MovieGenrePagingSource(
    private val apiService: ApiService,
    private val tags: Int
) : PagingSource<Int, MoviesDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesDto> {
        return try {
            val currentPage = params.key ?: 1
            delay(3000L)
            val response = apiService.getGenreWiseMovieList(genresId = tags, page = currentPage)
            val nextKey =   currentPage + 1
            val prevKey = if (currentPage == 1) null else currentPage - 1
            LoadResult.Page(
                data = response,
                prevKey = prevKey,
                nextKey = nextKey
            )
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
