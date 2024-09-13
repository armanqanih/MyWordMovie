package org.lotka.xenonx.presentation.screens.detail.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.lotka.xenonx.presentation.util.Constants.SpaceLarge
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceToLarge

@Composable
fun MovieInformation(
    ReleaseDate: String,
    Duration: String,
    Rating: String,
    Language: String
){
    Column(modifier = Modifier.fillMaxWidth()
        .padding(horizontal = SpaceToLarge),
        ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            TextsDetail(title = "Release Date",
                subTitle =ReleaseDate )
            Spacer(modifier = Modifier.width(SpaceToLarge))

            TextsDetail(title = "Duration",
                subTitle = Duration )
            Spacer(modifier = Modifier.width(SpaceToLarge))

            TextsDetail(title = "Rating",
                subTitle =Rating ,
                showRatingIcon = true
            )
            Spacer(modifier = Modifier.width(SpaceToLarge))
            TextsDetail(title = Language,
                subTitle ="English" )
        }

        Spacer(modifier = Modifier.height(SpaceLarge))

        Text(
            text = "Come Together .",
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.h2.copy(
                fontSize = 12.sp,
            ),
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(SpaceMedium))
        Text(
            text = "In a world where loyalty is tested," +
                    " and alliances are broken, " +
                    "former elite soldier Alex Grayson " +
                    "is forced out of hiding when a secret " +
                    "government agency frames him for a crime he didn’t commit." +
                    " With the clock ticking and enemies on all sides, " +
                    "Alex embarks on a deadly mission to clear his name " +
                    "and stop a shadowy organization from unleashing chaos " +
                    "across the globe. ",
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.h1.copy(
                fontSize = 10.sp,
            ),
            fontWeight = FontWeight.Medium
        )



    }

}
