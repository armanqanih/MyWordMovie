package org.lotka.xenonx.presentation.screens.detail
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


import androidx.hilt.navigation.compose.hiltViewModel
import org.lotka.xenonx.domain.models.WatchListModel
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_BACKDROP_IMAGE_URL
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL
import org.lotka.xenonx.presentation.screens.book_mark.BookMarkViewModel

import org.lotka.xenonx.presentation.screens.detail.compose.CastMediaSection
import org.lotka.xenonx.presentation.screens.detail.compose.DetailHeaderSection
import org.lotka.xenonx.presentation.screens.detail.compose.GenreChip
import org.lotka.xenonx.presentation.screens.detail.compose.MovieInformation
import org.lotka.xenonx.presentation.screens.detail.compose.OverviewSection
import org.lotka.xenonx.presentation.screens.detail.compose.SimilarMediaSection
import org.lotka.xenonx.presentation.util.Constants

import org.lotka.xenonx.presentation.util.Constants.SpaceLarge
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall
import org.lotka.xenonx.presentation.util.UiEvent
import java.text.SimpleDateFormat
import java.util.Date


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel = hiltViewModel(),
    bookMarkViewModel: BookMarkViewModel = hiltViewModel(),
    onNavigateUp: () -> Unit,
) {
    val scaffoldState = rememberScaffoldState()
    val detailState = detailViewModel.state.collectAsState().value
    val bookMarkState = bookMarkViewModel.state.collectAsState().value
    val exist = bookMarkState.exist
    val date = SimpleDateFormat.getDateInstance().format(Date())
    val detailMovie = detailState.movieDetail
    val watchListMovie = WatchListModel(
        mediaId = detailMovie!!.id,
        imagePath = detailMovie.backdropPath,
        title = detailMovie.title,
        releaseDate = detailMovie.releaseDate,
        rating = detailMovie.voteAverage,
        addedOn = date
    )

    LaunchedEffect(key1 = true){
        bookMarkViewModel.sharedFlow.collect{result->
            when(result){
                is UiEvent.ShowSnakeBar ->{
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = result.message
                    )
                }
            }
        }
    }



    Box(modifier = Modifier
        .fillMaxSize()
        , contentAlignment = Alignment.Center
    ){
        if(detailState.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        if (detailState.error.isNotBlank()) {
         Text(text = "We have an Error Message: ${detailState.error}",
             style = MaterialTheme.typography.h2,
             )
        }



        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = SpaceMedium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                DetailHeaderSection(
                    onNavigateUp = onNavigateUp,
                    backdropImageUrl =  BASE_BACKDROP_IMAGE_URL + detailMovie?.backdropPath,
                    posterImageUrl = BASE_POSTER_IMAGE_URL +detailMovie?.posterPath,
                    nameOfMovie = detailMovie?.title,
                    onBookmarkClick = {
                        if(exist !=0 ){
                            detailMovie?.id?.let { bookMarkViewModel.removeFromList(it) }
                        }else{
                            bookMarkViewModel.addToBookMark(watchListMovie)
                        }
                    }) }

// Type Of Movie
            item() {
                Spacer(modifier = Modifier.height(SpaceSmall))
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    FlowRow(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        detailMovie?.genres?.forEach {
                            GenreChip(genre = it.name)
                        }

                    }
                }

            }
            item {

                Spacer(modifier = Modifier.height(SpaceSmall))
                MovieInformation(
                    ReleaseDate = detailMovie.releaseDate,
                    Duration = detailMovie.runtime.toString(),
                    Rating = detailMovie.voteAverage.toString(),
                    Language = detailMovie.originalLanguage)


            }
            item {
//            OverViewSection
                OverviewSection(
                    overview = detailMovie.overview,
                    tagline = detailMovie.tagline)
            }

//        Cast

            item {

                Spacer(modifier = Modifier.height(SpaceLarge))
                CastMediaSection(castList = detailState.castList)
            }


// Similar Movies
            item {

                Spacer(modifier = Modifier.height(SpaceLarge))

                SimilarMediaSection(
                    media = detailState.movies,
                    onNavigateToDetail = {}
                )

            }}



}


    }





//

