package org.lotka.xenonx.presentation.screens.detail

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp
import org.lotka.xenonx.domain.models.Cast

import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.screens.detail.compose.CastMediaSection
import org.lotka.xenonx.presentation.screens.detail.compose.DetailHeaderSection
import org.lotka.xenonx.presentation.screens.detail.compose.GenreChip
import org.lotka.xenonx.presentation.screens.detail.compose.MovieInformation
import org.lotka.xenonx.presentation.screens.detail.compose.OverviewSection
import org.lotka.xenonx.presentation.screens.detail.compose.SimilarMediaSection

import org.lotka.xenonx.presentation.screens.detail.compose.TypeOfMovie
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.Constants.SpaceLarge
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall
import org.lotka.xenonx.presentation.util.Constants.SpaceToLarge


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailScreen(
  onNavigateUp:()-> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = SpaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            DetailHeaderSection(
                onNavigateUp = onNavigateUp,
                backdropImageUrl = "",
                posterImageUrl = "",
                nameOfMovie = "",
                onBookmarkClick = {

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
                  GenreChip(genre = "Action")
                }
            }

        }
        item {

            Spacer(modifier = Modifier.height(SpaceSmall))
            MovieInformation(
                ReleaseDate = "2022",
                Duration ="120 min",
                Rating = "4.5",
                Language = "English")


        }
        item {
//            OverViewSection
            OverviewSection(
                overview = "",
                tagline = "")
        }

//        Cast

        item {

            Spacer(modifier = Modifier.height(SpaceLarge))
            CastMediaSection(castList = listOf())
            }


// Similar Movies
        item {

            Spacer(modifier = Modifier.height(SpaceLarge))

            SimilarMediaSection(
                media = listOf(),
                onNavigateToDetail = {}
            )

        }}

    }





//

