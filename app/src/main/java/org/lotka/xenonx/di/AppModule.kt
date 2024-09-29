package org.lotka.xenonx.di

import android.app.Application
import androidx.databinding.adapters.Converters
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.lotka.xenonx.data.local.MovieDao
import org.lotka.xenonx.data.local.MovieDatabase
import org.lotka.xenonx.data.remote.api.ApiService
import org.lotka.xenonx.data.remote.repository.BookMarkRepositoryImpl
import org.lotka.xenonx.data.remote.repository.DetailRepositoryImpl
import org.lotka.xenonx.data.remote.repository.HomeRepositoryImpl
import org.lotka.xenonx.data.remote.repository.SearchRepositoryImpl
import org.lotka.xenonx.domain.repository.BookMarkRepository
import org.lotka.xenonx.domain.repository.DetailRepository
import org.lotka.xenonx.domain.repository.HomeRepository
import org.lotka.xenonx.domain.repository.SearchRepository
import org.lotka.xenonx.domain.usecase.boomark.BookMarksUseCase
import org.lotka.xenonx.domain.usecase.boomark.DeleterListUseCase
import org.lotka.xenonx.domain.usecase.boomark.ExistsUseCase
import org.lotka.xenonx.domain.usecase.boomark.GetAllWatchListUseCase
import org.lotka.xenonx.domain.usecase.boomark.InsertMoviesUseCase
import org.lotka.xenonx.domain.usecase.boomark.RemoveMovieFromListUseCase
import org.lotka.xenonx.domain.usecase.detail.DetailUseCases
import org.lotka.xenonx.domain.usecase.detail.GetCastMovieUseCase
import org.lotka.xenonx.domain.usecase.detail.GetDetailMoviesUseCase
import org.lotka.xenonx.domain.usecase.detail.GetSimilarMovieUseCase
import org.lotka.xenonx.domain.usecase.home.GetAllMoviesWithPaginationUseCase
import org.lotka.xenonx.domain.usecase.home.GetDiscoverMoviesUseCase
import org.lotka.xenonx.domain.usecase.home.GetMovieGenresUseCase
import org.lotka.xenonx.domain.usecase.home.GetMoviesByGenreUseCase
import org.lotka.xenonx.domain.usecase.home.GetNowPlayingMoviesUseCase
import org.lotka.xenonx.domain.usecase.home.GetPopularMoviesUseCase
import org.lotka.xenonx.domain.usecase.home.GetTrendingMoviesUseCase
import org.lotka.xenonx.domain.usecase.home.GetUpcomingMoviesUseCase
import org.lotka.xenonx.domain.usecase.home.HomeUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Provides
    @Singleton
    fun providesMovieDatabase(app: Application): MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "watch_list_table"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMoviesDao(db: MovieDatabase) = db.movieDao()
    @Provides
    fun provideBokMarkRepository( db: MovieDatabase): BookMarkRepository {
        return BookMarkRepositoryImpl(db)
    }
    @Provides
    fun provideSearchRepository(apiService: ApiService): SearchRepository {
        return SearchRepositoryImpl(apiService)
    }
    @Provides
    fun provideDetailRepository(apiService: ApiService): DetailRepository {
        return DetailRepositoryImpl(apiService)
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


    @Provides
    fun provideBookMarkUseCases(
        deleteListUseCase: DeleterListUseCase,
        insertMoviesUseCase: InsertMoviesUseCase,
        getAllWatchListUseCase: GetAllWatchListUseCase,
        existsUseCase: ExistsUseCase,
        removeMovieFromListUseCase: RemoveMovieFromListUseCase
        ): BookMarksUseCase {
        return BookMarksUseCase(
            deleterListUseCase = deleteListUseCase,
            getAllWatchListUseCase = getAllWatchListUseCase,
            insertMoviesUseCase = insertMoviesUseCase,
            existsUseCase = existsUseCase,
            removeMovieFromListUseCase = removeMovieFromListUseCase
        )
    }
    @Provides
    fun provideDetailUseCases(
        getDetailMoviesUseCase: GetDetailMoviesUseCase,
        getCastMovieUseCase: GetCastMovieUseCase,
        getSimilarMovieUseCase: GetSimilarMovieUseCase
        ):DetailUseCases {
        return DetailUseCases(
            getDetailMoviesUseCase = getDetailMoviesUseCase,
            getCastMovieUseCase = getCastMovieUseCase,
            getSimilarMovieUseCase = getSimilarMovieUseCase
        )
    }



}

