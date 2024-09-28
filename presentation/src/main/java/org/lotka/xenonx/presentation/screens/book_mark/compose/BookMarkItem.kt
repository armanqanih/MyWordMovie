package org.lotka.xenonx.presentation.screens.book_mark.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall


@Composable
fun BookMarkItem (
    imageUrl: String,
    title: String?,
    timestamp: String?,
    onNavigateToDetail: () -> Unit
){

    Row (modifier = Modifier.fillMaxWidth().
        padding(top = SpaceMedium, start = SpaceSmall)
        .clip(RoundedCornerShape(topStart = SpaceMedium,
            bottomStart = SpaceMedium))
        .background(color = MaterialTheme.colors.surface)
        .clickable { onNavigateToDetail() }
        , verticalAlignment = Alignment.CenterVertically
        ){
        Image( painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                .apply(block = fun ImageRequest.Builder.() {
                    size(Size.ORIGINAL)
                    scale(Scale.FILL)
                    crossfade(true)
                }).build()),
            contentDescription ="ImageBookMark" ,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(150.dp)
                .width(140.dp).
            clip(shape = RoundedCornerShape(SpaceMedium)),

            )
        Column(
            modifier = Modifier.padding(start = SpaceMedium),
            verticalArrangement = Arrangement.spacedBy(SpaceSmall)
            , horizontalAlignment = Alignment.Start
        ){

            if (title != null) {
                Text(text = title,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
            }
            if (timestamp != null) {
                Text(text = timestamp,
                        style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Medium
                )
            }

        }
    }

}