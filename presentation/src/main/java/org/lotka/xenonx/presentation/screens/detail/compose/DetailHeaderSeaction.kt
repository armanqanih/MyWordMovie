package org.lotka.xenonx.presentation.screens.detail.compose

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall

@Composable
fun DetailHeaderSection(
    modifier: Modifier = Modifier,
    onNavigateUp:()->Unit={},
    onBookmarkClick:()->Unit={} ,
    posterImageUrl:String="",
    backdropImageUrl:String="",
    nameOfMovie:String?=null

){

    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(SpaceMedium))
    ) {


        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context)
                    .data(backdropImageUrl)
                    .apply {
                        crossfade(true)
                        placeholder(R.drawable.placeholder)
                        error(R.drawable.placeholder)
                    }
                    .build()
            ) ,
            contentDescription = "Detail Header image"
        )
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .offset(y = (+90).dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(SpaceSmall))
                .shadow(elevation = 1.dp)
                .width(150.dp)
                .height(300.dp),
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context)
                    .data(posterImageUrl)
                    .apply {
                        crossfade(true)
                        placeholder(R.drawable.placeholder)
                        error(R.drawable.placeholder_error)
                    }
                    .build()
            ),
            contentDescription = "profile image"
        )

        // Row with icons (On top of the images)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter) // Align to the top center of the Box
                .padding(SpaceMedium),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .clickable {
                        onNavigateUp()
                    }
                    .padding(SpaceSmall)
                    .align(Alignment.CenterVertically)

                , imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "BackDetail",
                tint = MaterialTheme.colors.onBackground,
            )
            Icon(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .clickable {

                    }
                    .padding(SpaceSmall)
                    .align(Alignment.CenterVertically)
                ,
                imageVector = Icons.Default.BookmarkBorder,
                contentDescription = "BookMarkBorder",
                tint = MaterialTheme.colors.onBackground,
            )
        }


    }
    Spacer(modifier = Modifier.height(SpaceMedium))

//        Name Of Movie
    Text(
        text = nameOfMovie?:"Name Of Movie Is null",
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )


}