package org.lotka.xenonx.data.remote.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay
import org.lotka.xenonx.data.remote.Dto.models.SearchDto
import org.lotka.xenonx.data.remote.api.ApiService
import org.lotka.xenonx.domain.models.Search
import retrofit2.HttpException
import java.io.IOException

class SearchPagingSource (
    private val api: ApiService,
    private val searchParams: String,
    private val includeAdult: Boolean
    ) : PagingSource<Int, SearchDto>() {
        override fun getRefreshKey(state: PagingState<Int, SearchDto>): Int?{
        return state.anchorPosition?.let { anchorPosition ->
        state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
            ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
    }}
        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchDto> {
            return try {
                val currentPage = params.key ?: 1
                delay(3000L)
                /*error++
                if (error ==3)
                    throw IOException("My Custom error here")*/
                val nextKey =   currentPage + 1
                val prevKey = if (currentPage == 1) null else currentPage - 1
                val searchMovies = api.multiSearch(
                    page = currentPage,
                    searchParams = searchParams,
                    includeAdult = includeAdult
                )
                LoadResult.Page(
                    data = searchMovies,
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            } catch (e: IOException) {
                return LoadResult.Error(e)
            } catch (e: HttpException) {
                return LoadResult.Error(e)
            }
        }
    }
