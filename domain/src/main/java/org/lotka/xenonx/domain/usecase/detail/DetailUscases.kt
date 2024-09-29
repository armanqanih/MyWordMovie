package org.lotka.xenonx.domain.usecase.detail

data class DetailUseCases(
    val getDetailMoviesUseCase: GetDetailMoviesUseCase,
    val getCastMovieUseCase: GetCastMovieUseCase,
    val getSimilarMovieUseCase: GetSimilarMovieUseCase
)
