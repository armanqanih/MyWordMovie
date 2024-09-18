package org.lotka.xenonx.presentation.screens.see_all

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.util.Constants
import org.lotka.xenonx.domain.util.Constants.Companion.discoverListScreen
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.composable.StandardToolBar
import org.lotka.xenonx.presentation.screens.home.HomeViewModel
import org.lotka.xenonx.presentation.util.Constants.SpaceLarge
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall
import org.lotka.xenonx.domain.util.Constants.Companion.nowPlayingAllListScreen
import org.lotka.xenonx.domain.util.Constants.Companion.popularAllListScreen
import org.lotka.xenonx.domain.util.Constants.Companion.upcomingListScreen
import org.lotka.xenonx.presentation.screens.see_all.compose.MovieItemSeeAll
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SeeAllScreen(
      selectedTitle: String,
      onNavigateToSearchScreen:(String)->Unit,
      onNavigateDetailScreen:(String)->Unit,
      onNavigateUp:()->Unit={}
) {
    val viewModel: HomeViewModel = hiltViewModel()
    var allMoviesPagination: LazyPagingItems<Movies>? = null
    var title = ""

    BackHandler(
        enabled = true
    ) {
      onNavigateUp()
    }


    when (selectedTitle) {
        nowPlayingAllListScreen -> {
            title = "Now Playing"
            allMoviesPagination = viewModel.nowPlayingAllListState.collectAsLazyPagingItems()
        }

        discoverListScreen -> {
            title = "Discover"
            allMoviesPagination = viewModel.discoverListState.collectAsLazyPagingItems()

        }

        upcomingListScreen -> {
            title = "Upcoming"
            allMoviesPagination = viewModel.upcomingListState.collectAsLazyPagingItems()

        }

        popularAllListScreen -> {
            title = "Popular"
            allMoviesPagination = viewModel.popularAllListState.collectAsLazyPagingItems()
        }

        else -> ""
    }





    Column(modifier = Modifier.fillMaxSize()) {
            StandardToolBar(
                modifier = Modifier.fillMaxWidth(),
                onNavigateUp = onNavigateUp,
                showBackArrow = true,
                title = {
                    Text(
                        text = "              $title",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold
                    )
                },
                navAction = {
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = { }) {
                        Icon(
                            modifier = Modifier.clickable {
                                onNavigateToSearchScreen(
                                    ScreensNavigation.searchScreen.route

                                )
                            },
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "search",
                            tint = MaterialTheme.colors.onBackground
                        )
                    }

                }


            )





        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 3 items per row
            modifier = Modifier
                .fillMaxSize()

                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(allMoviesPagination?.itemCount ?: 0) { index -> // Adjust the item count as needed
                MovieItemSeeAll(
                    media = allMoviesPagination?.get(index),
                    onNavigateToDetail =  onNavigateDetailScreen)
            }

        }}

}


