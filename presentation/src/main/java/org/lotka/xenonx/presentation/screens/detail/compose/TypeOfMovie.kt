package org.lotka.xenonx.presentation.screens.detail.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TypeOfMovie(
    text:String,
    eachItem:Int = 3
){
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = SpaceSmall, end = SpaceSmall)
            .padding(SpaceSmall),
        maxItemsInEachRow = 7,
        horizontalArrangement = Arrangement.Center, // Adds space between items
        verticalArrangement = Arrangement.spacedBy(SpaceSmall)
    ) {
        // Adding 5 items to the row
        repeat(eachItem) {
            Spacer(modifier = Modifier.width(SpaceSmall))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(Constants.SpaceMedium))
                    .background(MaterialTheme.colors.primary)
                    .border(
                        2.dp,
                        color = MaterialTheme.colors.onBackground,
                        shape = RoundedCornerShape(Constants.SpaceMedium)
                    )
                    .padding(SpaceSmall),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    color = MaterialTheme.colors.onBackground,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.body1,
                )
            }

        }





    }

}