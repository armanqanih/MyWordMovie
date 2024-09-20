package org.lotka.xenonx.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import org.lotka.xenonx.domain.util.Constants.Companion.nowPlayingAllListScreen
import org.lotka.xenonx.presentation.composable.StandardToolBar
import org.lotka.xenonx.presentation.screens.home.compose.DisPlayMovieSection
import org.lotka.xenonx.presentation.screens.home.compose.Geners
import org.lotka.xenonx.presentation.screens.home.compose.HeaderSection
import org.lotka.xenonx.presentation.screens.home.compose.PlayNowSection
import org.lotka.xenonx.presentation.screens.home.compose.PopularMovieSection
import org.lotka.xenonx.presentation.screens.home.compose.UpCommonMovieSection
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToDetailPlayNow:(String)->Unit,
    onNavigateToMorePlayNow:(String)->Unit,
    onNavigateToPopular:(String)->Unit,
    onNavigateToDiscover:(String)->Unit,
    onNavigateToUpCommon:(String)->Unit,
    onSearchClick:(String)->Unit,

    ) {

     val state = viewModel.state.collectAsState().value
    val moviesLazyPagingItems = viewModel.popularAllListState.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){



        if (state.isLoading) {
            CircularProgressIndicator()
        }else{

            Column(modifier = Modifier.fillMaxSize()
            ) {
                if (state.error.isNotEmpty()) {
                    Text(text = "Oops ${state.error}",
                        style = MaterialTheme.typography.h1.copy(
                            fontSize = 24.sp
                        ),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.background(
                            MaterialTheme.colors.onBackground
                        )
                    )

                }
                StandardToolBar(
                    modifier = Modifier.fillMaxWidth(),
                    showBackArrow = true,
                    icon = Icons.Filled.Menu,
                    title = {
                        Text(text = "Home Movie",
                            color = MaterialTheme.colors.onBackground,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navAction = {
                        IconButton(onClick = { onSearchClick(
                            ScreensNavigation.searchScreen.route
                        )}) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = MaterialTheme.colors.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(onClick = {  }) {
                            Icon(
                                imageVector = Icons.Outlined.Bookmarks,
                                contentDescription = "bookMarks",
                                tint = MaterialTheme.colors.onBackground
                            )
                        }

                    }



                )


                LazyColumn (modifier = Modifier
                    .fillMaxSize()
                    .padding(Constants.SpaceMedium)
                ){

                    item{
                        state.movies?.take(5)?.let {
                            HeaderSection(
                                images = it,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(SpaceSmall))
                        state.genre?.let {
                            Geners(genre = it) }

                    }

                    item{
                        Spacer(modifier = Modifier.height(Constants.SpaceMedium))
                        PlayNowSection(
                            onNavigateTo = onNavigateToDetailPlayNow,
                            movies = state.nowPlayingMovies.orEmpty(),
                            onMoreClick = {
                               onNavigateToMorePlayNow(
                                   ScreensNavigation.seeAllScreen.route + "/${nowPlayingAllListScreen}"
                               )
                            }
                        )
                    }

                    item {
                        PopularMovieSection(
                            onNavigate = onNavigateToPopular,
                            viewModel = viewModel
                        )
                    }


                    item{
                        Spacer(modifier = Modifier.height(Constants.SpaceMedium))
                        DisPlayMovieSection()
                    }
                    item {
                        Spacer(modifier = Modifier.height(Constants.SpaceMedium))
                        UpCommonMovieSection()
                    }


                }


            }



        }



    }

}