package org.lotka.xenonx.data.remote.repository


import coil.network.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lotka.xenonx.data.remote.Dto.models.toMovie
import org.lotka.xenonx.data.remote.api.ApiService
import org.lotka.xenonx.data.remote.response.toMovieDetail
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.repository.DetailRepository
import org.lotka.xenonx.domain.response.CastResponse
import org.lotka.xenonx.domain.response.MovieDetails
import org.lotka.xenonx.domain.util.Resource
import java.io.IOException
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val api : ApiService
):DetailRepository {
    override fun getMoviesDetails(movieId: String): Flow<Resource<MovieDetails>> {
       return flow {
           try {
               emit(Resource.Loading(true))
               val remoteResponse = api.getMoviesDetails(movieId.toInt()).toMovieDetail()
               emit(Resource.Success(remoteResponse))
           }catch (e: HttpException) {
               emit(Resource.Error("Network error: ${e.message}"))
           } catch (e: IOException) {
               emit(Resource.Error("Check your internet connection"))
           } catch (e: Exception) {
               emit(Resource.Error("Oops, something went wrong!!"))


       }}
    }

    override fun getCastMoviesRepo(movieId: String): Flow<Resource<CastResponse>> {
        return flow {
            try {
                emit(Resource.Loading(true))
            val remoteResponse = api.getMovieCast(movieId.toInt())
                emit(Resource.Success(remoteResponse))


            }catch (e: HttpException) {
                emit(Resource.Error("Network error: ${e.message}"))
            } catch (e: IOException) {
                emit(Resource.Error("Check your internet connection"))
            } catch (e: Exception) {
                emit(Resource.Error("Oops, something went wrong!!"))


        }}
    }

    override fun getSimilarMoviesRepo(movieId: String): Flow<Resource<List<Movies>>> {
        return flow {
            try {
                emit(Resource.Loading(true))
              val remoteResponse = api.getSimilarMovies(movieId.toInt()).map { it.toMovie() }
                emit(Resource.Success(remoteResponse))
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