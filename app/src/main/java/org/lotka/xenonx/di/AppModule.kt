package org.lotka.xenonx.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.lotka.xenonx.data.remote.api.ApiService
import org.lotka.xenonx.data.remote.repository.HomeRepositoryImpl
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.usecase.GetAllMoviesWithPaginationUseCase
import org.lotka.xenonx.domain.usecase.GetDiscoverMoviesUseCase
import org.lotka.xenonx.domain.usecase.GetMovieGenresUseCase
import org.lotka.xenonx.domain.usecase.GetMoviesByGenreUseCase
import org.lotka.xenonx.domain.usecase.GetNowPlayingMoviesUseCase
import org.lotka.xenonx.domain.usecase.GetPopularMoviesUseCase
import org.lotka.xenonx.domain.usecase.GetTrendingMoviesUseCase
import org.lotka.xenonx.domain.usecase.GetUpcomingMoviesUseCase
import org.lotka.xenonx.domain.usecase.HomeUseCases

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideHomeRepository(apiService: ApiService): HomeRepository {
        return HomeRepositoryImpl(apiService)
    }
    @Provides
    fun provideHomeUseCases(
        getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
        getPopularMoviesUseCase: GetPopularMoviesUseCase,
        getDiscoverMoviesUseCase: GetDiscoverMoviesUseCase,
        getGenresWiseMovieUseCase: GetMoviesByGenreUseCase,
        getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
        getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
        getMovieGenresUseCase: GetMovieGenresUseCase,
        getAllMoviesWithPaginationUseCase: GetAllMoviesWithPaginationUseCase,
    ): HomeUseCases {
        return HomeUseCases(
            getNowPlayingMoviesUseCase,
            getPopularMoviesUseCase,
            getDiscoverMoviesUseCase,
            getGenresWiseMovieUseCase,
            getTrendingMoviesUseCase,
            getUpcomingMoviesUseCase,
            getMovieGenresUseCase,
            getAllMoviesWithPaginationUseCase
        )
    }
}

