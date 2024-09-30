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
    ReleaseDate: String?,
    Duration: String,
    Rating: String,
    Language: String?
){
    Column(modifier = Modifier.fillMaxWidth()
        .padding(horizontal = SpaceToLarge),
        ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            if (ReleaseDate != null) {
                TextsDetail(title = "Release Date",
                    subTitle =ReleaseDate )
            }
            Spacer(modifier = Modifier.width(SpaceToLarge))

            TextsDetail(title = "Duration",
                subTitle = Duration )
            Spacer(modifier = Modifier.width(SpaceToLarge))

            TextsDetail(title = "Rating",
                subTitle =Rating ,
                showRatingIcon = true
            )
            Spacer(modifier = Modifier.width(SpaceToLarge))
            if (Language != null) {
                TextsDetail(title = Language,
                    subTitle ="English" )
            }
        }





    }

}
