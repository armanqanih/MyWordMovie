package org.lotka.xenonx.presentation.screens.search

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew

import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.composable.ErrorStrip
import org.lotka.xenonx.presentation.screens.search.compose.SearchMovieCard
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.Constants.SpaceLarge
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall
import org.lotka.xenonx.presentation.util.Constants.SpaceToLarge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    onNavigateTo:(String)->Unit = {},
    onNavigateUp:()->Unit = {}
){

    val state = viewModel.state.collectAsState().value
    val multiSearchState = state.multiSearchState.collectAsLazyPagingItems()

    val context = LocalContext.current


  Scaffold(modifier = Modifier.fillMaxSize(),
      topBar = {
          Row (modifier = Modifier
              .fillMaxWidth()
              .background(color = MaterialTheme.colors.surface)
          ){
              IconButton(onClick = {  onNavigateUp() }) {
                  Icon(
                      modifier = Modifier
                          .padding(vertical = SpaceLarge)
                          .align(Alignment.CenterVertically)
                          .clip(shape = CircleShape)
                      , imageVector = Icons.Default.ArrowBackIosNew,
                      contentDescription = "BackDetail",
                      tint = MaterialTheme.colors.onBackground,
                  )
              }

              SearchBar(
                  colors = SearchBarDefaults.colors(
                      containerColor = MaterialTheme.colors.surface,
                      dividerColor = MaterialTheme.colors.surface,
                      inputFieldColors = SearchBarDefaults.inputFieldColors(
                          cursorColor = MaterialTheme.colors.onBackground,
                          focusedTextColor =MaterialTheme.colors.onBackground,

                          )),
                  modifier = Modifier.fillMaxWidth(),
                  query = state.searchQuery,
                  onQueryChange = {
                      viewModel.onEvent(SearchEvent.UpdateSearchQuery(it))
                  },
                  onSearch = {
                      if (state.searchQuery.isNotEmpty()) {
                         state.searchQuery = state.searchQuery
                          viewModel.searchRemoteMovie(true)
                          state.searchActive = false
                      } else {
                          Toast.makeText(context, "Enter the text", Toast.LENGTH_LONG).show()
                      }
                  },
                  enabled = true,
                  placeholder = {
                      Text(
                          text = "Search...",
                          style = MaterialTheme.typography.body1
                      )
                  },
                  shape = CircleShape,
                  trailingIcon = {
                      Icon(
                          modifier = Modifier
                               // Replace SpaceSmall with dp padding value
                          , imageVector = Icons.Outlined.Cancel,
                          contentDescription = "Cancel Search",
                          tint = MaterialTheme.colors.onBackground,
                      )

                  },
                  leadingIcon = {
                      Icon(
                          modifier = Modifier
                                // Replace SpaceSmall with dp padding value
                          , imageVector = Icons.Default.Search,
                          contentDescription = "Search Icon",
                          tint = MaterialTheme.colors.onBackground,
                      )
                  },
                  active = state.searchActive,
                  onActiveChange = {
                      state.searchActive = it
                  }){



              }






          }

      }
      ) {

      Spacer(modifier = Modifier.height(SpaceLarge))

      Box (modifier = Modifier.fillMaxSize().padding(it)
          ) {
          if (state.isLoadingFirstTime) {
              CircularProgressIndicator(
                  modifier = Modifier.fillMaxWidth()
                      .padding(16.dp)
                      .align(Alignment.Center)
                      .wrapContentWidth(Alignment.CenterHorizontally))
          }


          LazyColumn(
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = SpaceSmall)
          ) {

              items(multiSearchState.itemCount) {indxt->
                  val movie = multiSearchState[indxt]
                  val imageUrl = movie?.posterPath?.let { posterPath->
                      BASE_POSTER_IMAGE_URL + posterPath
                  }
                  SearchMovieCard(
                      imageUrl = imageUrl,
                      title = movie?.title ,
                      overview = movie?.overview,
                      onNavigate = {
                          onNavigateTo(
                              ScreensNavigation.detailScreen.route
                              + "/${movie?.id}"
                          )
                      }
                      )



              }
              item {
                  if (state.isLoadingNewPosts) {
                      CircularProgressIndicator(
                          modifier = Modifier.fillMaxWidth()
                              .padding(16.dp)
                              .align(Alignment.Center)
                              .wrapContentWidth(Alignment.CenterHorizontally))

                  }
              }


              multiSearchState.apply {
                  when {
                      // Handling the initial loading state
                      loadState.refresh is LoadState.Loading -> {
                          item {
                              viewModel.onEvent(SearchEvent.LoadedPage)
                          }
                      }

                      loadState.append is LoadState.Loading -> {
                          item {  viewModel.onEvent(SearchEvent.LoadMorePosts) }
                      }

                      loadState.refresh is LoadState.Error -> {
                          val e = multiSearchState.loadState.refresh as LoadState.Error
                          item {
                              ErrorStrip(message = e.error.message ?: "Unknown Error")
                          }
                      }

                      loadState.append is LoadState.Error -> {
                          val e = multiSearchState.loadState.append as LoadState.Error
                          item {
                              ErrorStrip(message = e.error.message ?: "Unknown Error")
                          }
                      }
                  }
              }


          }

      }
  }




}