package org.lotka.xenonx.presentation.screens.detail.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall

@Composable
fun TextsDetail(
    title:String,
    subTitle:String,
    showRatingIcon:Boolean = false,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(SpaceSmall),
    ){

        Text(
            text = title,
            color = MaterialTheme.colors.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.subtitle2,
        )

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            if (showRatingIcon){
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating",
                    tint = MaterialTheme.colors.secondary
                    )
            }else null

            Text(
                text = subTitle,
                color = MaterialTheme.colors.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body2
                ,
            )
        }


    }
}