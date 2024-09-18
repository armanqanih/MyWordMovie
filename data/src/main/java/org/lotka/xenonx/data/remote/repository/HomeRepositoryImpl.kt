package org.lotka.xenonx.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import coil.network.HttpException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.lotka.xenonx.data.remote.api.ApiService
import org.lotka.xenonx.data.remote.Dto.models.toGenre
import org.lotka.xenonx.data.remote.Dto.models.toMovie
import org.lotka.xenonx.data.remote.pagination.MovieGenrePagingSource
import org.lotka.xenonx.data.remote.pagination.MoviePagingSource
import org.lotka.xenonx.data.remote.response.toGenreResponse
import org.lotka.xenonx.data.remote.response.toMovieResponse
import org.lotka.xenonx.domain.models.Genre
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.response.GenreResponse
import org.lotka.xenonx.domain.response.MovieResponse
import org.lotka.xenonx.domain.util.Resource
import java.io.IOException
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor (
    private val apiService : ApiService
):HomeRepository {
    override suspend fun getNowPlayingMovies(page:Int): Flow<Resource<List<Movies>>> {
        return flow {
                try {
                    val response = apiService.getNowPlayingMovies(page)
                    val movies = response.map { it.toMovie() }
                    emit(Resource.Success(movies))
                    emit(Resource.Loading(false))
                }catch (e: HttpException) {
                    emit(Resource.Error("Network error: ${e.message}"))
                } catch (e: IOException) {
                    emit(Resource.Error("Check your internet connection"))
                } catch (e: Exception) {
                    emit(Resource.Error("Oops, something went wrong!!"))


                }

        }
    }

    override suspend fun getPopularMovies(page:Int): Flow<Resource<List<Movies>>> {
        return flow {

                try {
                    val response = apiService.getPopularMovies(page)
                    val movies = response.map { it.toMovie() }
                    emit(Resource.Success(movies))
                    emit(Resource.Loading(false))
                }catch (e: HttpException) {
                    emit(Resource.Error("Network error: ${e.message}"))
                } catch (e: IOException) {
                    emit(Resource.Error("Check your internet connection"))
                } catch (e: Exception) {
                    emit(Resource.Error("Oops, something went wrong!!"))


                }

        }
    }

    override suspend fun getDiscoverMoviesRepo(page:Int): Flow<Resource<List<Movies>>> {
        return flow {
            emit(Resource.Loading(true))
                try {   val response = apiService.getDiscoverMovies(page)
                    val movies = response.map { it.toMovie() }
                    emit(Resource.Success(movies))
                    emit(Resource.Loading(false))

                }catch (e: HttpException) {
                    emit(Resource.Error("Network error: ${e.message}"))
                } catch (e: IOException) {
                    emit(Resource.Error("Check your internet connection"))
                } catch (e: Exception) {
                    emit(Resource.Error("Oops, something went wrong!!"))


                }}
    }

    override fun getAllMoviesPagination(tags: String):Flow<PagingData<Movies>> {
        return flow {

                   Pager(
                        config = PagingConfig(
                            pageSize = 20,
                            enablePlaceholders = false
                        ),
                        pagingSourceFactory = { MoviePagingSource(apiService,tags) }
                    )


        }
    }


    override fun getGenresWiseMovieRepo(tags: Int):Flow<PagingData<Movies>>  {
        return flow {

                Pager(
                    config = PagingConfig(
                        pageSize = 20,
                        enablePlaceholders = false
                    ),
                    pagingSourceFactory = { MovieGenrePagingSource(apiService,tags) }
                )

        }
    }

    override suspend fun getTrendingMoviesRepo(page:Int): Flow<Resource<List<Movies>>> {
        return flow {

                try {
                    val response = apiService.getTrendingMovies(page)
                    val movies = response.map { it.toMovie() }
                    emit(Resource.Success(movies))
                    emit(Resource.Loading(false))

                }catch (e: HttpException) {
                    emit(Resource.Error("Network error: ${e.message}"))
                } catch (e: IOException) {
                    emit(Resource.Error("Check your internet connection"))
                } catch (e: Exception) {
                    emit(Resource.Error("Oops, something went wrong!!"))


                }

        }
    }

    override suspend fun getUpcomingMoviesRepo(page:Int): Flow<Resource<List<Movies>>> {
        return flow {

                try {
                    val response = apiService.getUpcomingMovies(page)
                    val movies = response.map { it.toMovie() }
                    emit(Resource.Success(movies))
                    emit(Resource.Loading(false))

                }catch (e: HttpException) {
                    emit(Resource.Error("Network error: ${e.message}"))
                } catch (e: IOException) {
                    emit(Resource.Error("Check your internet connection"))
                } catch (e: Exception) {
                    emit(Resource.Error("Oops, something went wrong!!"))


                }

        }
    }

    override suspend fun getMovieGenresRepo(): Flow<Resource<List<Genre>>> {
        return flow {

                try {
                    val response = apiService.getMovieGenres()
                    val movies = response.map { it.toGenre() }
                    emit(Resource.Success(movies))
                    emit(Resource.Loading(false))
                }catch (e: HttpException) {
                    emit(Resource.Error("Network error: ${e.message}"))
                } catch (e: IOException) {
                    emit(Resource.Error("Check your internet connection"))
                } catch (e: Exception) {
                    emit(Resource.Error("Oops, something went wrong!!"))


                }
        }
    }


}