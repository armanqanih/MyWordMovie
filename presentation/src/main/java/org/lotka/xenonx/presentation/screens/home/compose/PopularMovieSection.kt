package org.lotka.xenonx.presentation.screens.home.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.composable.CenteredCircularProgressIndicator
import org.lotka.xenonx.presentation.composable.ErrorStrip
import org.lotka.xenonx.presentation.composable.StandardHeaderText
import org.lotka.xenonx.presentation.composable.StandardTextMore
import org.lotka.xenonx.presentation.screens.home.HomeViewModel
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.Constants

@Composable
fun PopularMovieSection(
    onNavigate:(String)->Unit = {},
    viewModel: HomeViewModel = hiltViewModel()
){

    val moviesLazyPagingItems = viewModel.popularAllListState.collectAsLazyPagingItems()
    // Popular Movie

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 2.dp)
    ){
        StandardHeaderText(
            modifier = Modifier.weight(8f),
            text = "Popular Movie",
            showIcon = true,
            iconImage = Icons.Default.Stars
        )
        StandardTextMore(
            modifier = Modifier.weight(2f),
            onClick = {

            }
        )
    }

    Spacer(modifier = Modifier.height(Constants.SpaceMedium))

    LazyRow(modifier = Modifier.fillMaxWidth()){
        items(moviesLazyPagingItems.itemCount){ indxt->
            if (indxt!=0){
                Spacer(modifier = Modifier.width(Constants.SpaceSmall))
            }

            HomeSmallThumb(
                imageUrl = BASE_POSTER_IMAGE_URL
                + moviesLazyPagingItems[indxt]?.backdropPath,
               onNavigateTo = {
                   onNavigate(
                       ScreensNavigation.detailScreen.route
                       +"/${moviesLazyPagingItems[indxt]?.id}"
                   )
               }

            )
        }

        moviesLazyPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {   }
                }

                loadState.append is LoadState.Loading -> {
                    item {   }
                }

                loadState.refresh is LoadState.Error -> {
                    val e = moviesLazyPagingItems.loadState.refresh as LoadState.Error
                    item { e.error.localizedMessage?.let { ErrorStrip(message = it) } }
                }

                loadState.append is LoadState.Error -> {
                    val e = moviesLazyPagingItems.loadState.append as LoadState.Error
                    item { e.error.localizedMessage?.let { ErrorStrip(message = it) } }
                }
            }
        }

    }

}