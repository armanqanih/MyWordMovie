package org.lotka.xenonx.presentation.screens.see_all.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_POSTER_IMAGE_URL
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.Constants.SpaceLarge
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall

@Composable
fun MovieItemSeeAll(
    media: Movies?,
    onNavigateToDetail:(String)->  Unit = {},
    modifier: Modifier = Modifier,
) {

    val imageUrl = "${BASE_POSTER_IMAGE_URL}${media?.posterPath}"


    val imagePainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .size(Size.ORIGINAL)
            .build()
    )
    val imageState = imagePainter.state

    val defaultDominantColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer
    var dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = RoundedCornerShape(SpaceMedium))
            .shadow(elevation = 4.dp)
            .clickable {
                onNavigateToDetail(
                    ScreensNavigation.detailScreen.route
                    +"/${media?.id}"
                )
            }
            .background(color = MaterialTheme.colors.surface),
    ) {

        if (imageState is AsyncImagePainter.State.Success) {
            val imageBitmap = imageState.result.drawable.toBitmap()
            Image(
                bitmap = imageBitmap.asImageBitmap(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(SpaceMedium)),
                contentDescription = "header image"

            )
        }
        if (imageState is AsyncImagePainter.State.Error) {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp))
                    .background(androidx.compose.material3.MaterialTheme.colorScheme.background)
                    .padding(32.dp)
                    .alpha(0.8f),
                painter = painterResource(id = R.drawable.ic_broken_image),
                contentDescription = "",
                tint = androidx.compose.material3.MaterialTheme.colorScheme.onBackground
            )
        }

        if (imageState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(
                color = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.Center)
                    .scale(0.5f)
            )
        }


        Column (modifier = Modifier
            .fillMaxWidth().background(
                Brush.verticalGradient(
                    colors = listOf(
                        androidx.compose.material3.MaterialTheme.colorScheme.secondaryContainer,
                        dominantColor
                    )
                )
            )
            .padding(bottom = SpaceSmall)
            .align(Alignment.BottomCenter),

            ){
            media?.title?.let {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = it,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,


                    )
            }
            Row (
                modifier = Modifier.padding(horizontal = SpaceLarge),
                verticalAlignment = Alignment.CenterVertically,

                ){
                Icon(
                    modifier = Modifier.size(14.dp),
                    imageVector = Icons.Default.Star
                    , contentDescription = "Star",
                    tint = MaterialTheme.colors.secondary
                )

                Text(
                    modifier = Modifier
                    ,
                    text = media?.voteAverage.toString().take(3),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.body2,


                    )
            }

        }


    }

}
