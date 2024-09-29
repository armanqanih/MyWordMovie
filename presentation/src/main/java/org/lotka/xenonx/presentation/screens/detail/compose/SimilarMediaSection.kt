package org.lotka.xenonx.presentation.screens.detail.compose
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable


import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL

import org.lotka.xenonx.presentation.screens.home.compose.HomeSmallThumb
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation


@Composable
fun SimilarMediaSection(
    media: List<Movies>,
    onNavigateToDetail:(String)->Unit={},
) {

    if (media.isNotEmpty()) Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 22.dp, end = 22.dp, top = 22.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Similar Movies",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 18.sp
            )


        }
        LazyRow(
            modifier = Modifier.padding(
                start = 22.dp, end = 22.dp, top = 8.dp, bottom = 16.dp
            )
        ) {
            items(media.size) {indxt->
                HomeSmallThumb(
                    BASE_POSTER_IMAGE_URL + media[indxt].posterPath,
                    onNavigateTo = {
                        onNavigateToDetail(
                           ScreensNavigation.detailScreen.route +"/${media[indxt].id}"
                        )
                    })
            }
        }
    }

}