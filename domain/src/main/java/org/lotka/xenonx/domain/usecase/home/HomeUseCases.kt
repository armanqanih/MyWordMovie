package org.lotka.xenonx.domain.usecase.home



import javax.inject.Inject

class HomeUseCases @Inject constructor(
    val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    val getDiscoverMoviesUseCase: GetDiscoverMoviesUseCase,
    val getGenresWiseMovieUseCase: GetMoviesByGenreUseCase,
    val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
    val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    val getMovieGenresUseCase: GetMovieGenresUseCase,
    val getAllMoviesWithPaginationUseCase: GetAllMoviesWithPaginationUseCase
)
