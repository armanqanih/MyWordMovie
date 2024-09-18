package org.lotka.xenonx.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.lotka.xenonx.data.remote.api.ApiService
import org.lotka.xenonx.data.remote.repository.HomeRepositoryImpl
import org.lotka.xenonx.data.remote.repository.SearchRepositoryImpl
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.repository.SearchRepository
import org.lotka.xenonx.domain.usecase.home.GetAllMoviesWithPaginationUseCase
import org.lotka.xenonx.domain.usecase.home.GetDiscoverMoviesUseCase
import org.lotka.xenonx.domain.usecase.home.GetMovieGenresUseCase
import org.lotka.xenonx.domain.usecase.home.GetMoviesByGenreUseCase
import org.lotka.xenonx.domain.usecase.home.GetNowPlayingMoviesUseCase
import org.lotka.xenonx.domain.usecase.home.GetPopularMoviesUseCase
import org.lotka.xenonx.domain.usecase.home.GetTrendingMoviesUseCase
import org.lotka.xenonx.domain.usecase.home.GetUpcomingMoviesUseCase
import org.lotka.xenonx.domain.usecase.home.HomeUseCases

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideSearchRepository(apiService: ApiService): SearchRepository {
        return SearchRepositoryImpl(apiService)
    }


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

