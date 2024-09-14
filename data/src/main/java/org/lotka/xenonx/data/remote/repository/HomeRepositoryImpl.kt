package org.lotka.xenonx.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import org.lotka.xenonx.data.remote.ApiService
import org.lotka.xenonx.data.remote.Dto.models.toMovie
import org.lotka.xenonx.domain.models.Genre
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor (
    private val apiService : ApiService
):HomeRepository {
    override suspend fun getNowPlayingMovies(page:Int): Flow<Resource<Movies>> {
        return flow {
            emit(Resource.Loading())
            withContext(Dispatchers.IO){
                try {
                    val response = apiService.getNowPlayingMovies(page)
                    val movies = response.toMovie()
                    emit(Resource.Success(movies))

                }catch (e:Exception){
                    emit(Resource.Error(e.message ?: "Oops some thing went wrong"))
                }
            }
        }
    }

    override suspend fun getPopularMovies(): Flow<Resource<Movies>> {
        return flow {
            withContext(Dispatchers.IO){
                try {


                }catch (e:Exception){
                    emit(Resource.Error(e.message ?: "Oops some thing went wrong"))
                }
            }
        }
    }

    override suspend fun getDiscoverMoviesRepo(): Flow<Resource<Movies>> {
        return flow {
            withContext(Dispatchers.IO){
                try {


                }catch (e:Exception){
                    emit(Resource.Error(e.message ?: "Oops some thing went wrong"))
                }
            }
        }
    }

    override fun getAllMoviesPagination(tags: String):Flow<PagingData<Movies>> {
        return flow {
            withContext(Dispatchers.IO){
                try {


                }catch (e:Exception){

                }
            }
        }
    }


    override fun getGenresWiseMovieRepo(tags: Int):Flow<PagingData<Movies>>  {
        return flow {
            withContext(Dispatchers.IO){
                try {


                }catch (e:Exception){

                }
            }
        }
    }

    override fun getTrendingMoviesRepo(): Flow<Resource<Movies>> {
        return flow {
            withContext(Dispatchers.IO){
                try {


                }catch (e:Exception){
                    emit(Resource.Error(e.message ?: "Oops some thing went wrong"))
                }
            }
        }
    }

    override fun getUpcomingMoviesRepo(): Flow<Resource<Movies>> {
        return flow {
            withContext(Dispatchers.IO){
                try {


                }catch (e:Exception){
                    emit(Resource.Error(e.message ?: "Oops some thing went wrong"))
                }
            }
        }
    }

    override fun getMovieGenresRepo(): Flow<Resource<Genre>> {
        return flow {
            withContext(Dispatchers.IO){
                try {


                }catch (e:Exception){
                    emit(Resource.Error(e.message ?: "Oops some thing went wrong"))
                }
            }
        }
    }


}