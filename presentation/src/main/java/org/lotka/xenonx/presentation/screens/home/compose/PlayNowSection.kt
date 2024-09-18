package org.lotka.xenonx.presentation.screens.home.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Stars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.composable.StandardHeaderText
import org.lotka.xenonx.presentation.composable.StandardTextMore
import org.lotka.xenonx.presentation.screens.home.HomeViewModel
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.Constants

@Composable
fun PlayNowSection(
    movies :List<Movies>,
    onMoreClick:()->Unit = {},
    onNavigateTo:(String)->Unit = {}
){



    Column(modifier = Modifier.fillMaxWidth()){

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
            ){
            StandardHeaderText(
                modifier = Modifier.weight(8f),
                text = "Play Now",)
            StandardTextMore(
                modifier = Modifier.weight(2f),
                onClick = {
                   onMoreClick()
                }
            )
        }

        Spacer(modifier = Modifier.height(Constants.SpaceMedium))

        LazyRow(modifier = Modifier.fillMaxWidth()){
            items(movies.size){index->
                if (index!=0){
                    Spacer(modifier = Modifier.width(Constants.SpaceSmall))
                }
                HomeSmallThumb(
                    imageUrl = BASE_POSTER_IMAGE_URL
                    + movies[index].backdropPath
                , onNavigateTo = {
                    onNavigateTo(ScreensNavigation.detailScreen.route
                    + "/${movies[index].id}"
                    )
                    }
                )
                }
            }
        }

        Spacer(modifier = Modifier.height(Constants.SpaceMedium))



    }

