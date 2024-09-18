package org.lotka.xenonx.presentation.screens.search.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall
import org.lotka.xenonx.presentation.util.Constants.SpaceToLarge

@Composable
fun SearchMovieCard(
    imageUrl: String?,
    title: String?,
    overview: String?,
    onNavigate: () -> Unit,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(SpaceMedium))
            .background(color = MaterialTheme.colors.surface),
        horizontalArrangement = Arrangement.Center
    ) {
    if (imageUrl != null){
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        size(Size.ORIGINAL)
                        scale(Scale.FILL)
                        crossfade(true)
                    }).build()
            ),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(SpaceMedium)),
            contentDescription = "header image"
        )
    }else{
        Image(
            painter = painterResource(id = R.drawable.ic_broken_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(SpaceMedium)),
            contentDescription = "header image"
        )


    }
  
        Spacer(modifier = Modifier.width(SpaceSmall))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SpaceToLarge),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceSmall),
                text = title?:"The Son Of Super Man Super max ",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,

                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1,
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceSmall),
                text = overview?:"New Movies Coming ",
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body2,
            )
        }


    }



}