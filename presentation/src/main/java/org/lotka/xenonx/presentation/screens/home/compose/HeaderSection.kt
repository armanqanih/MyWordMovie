package org.lotka.xenonx.presentation.screens.home.compose

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay
import org.lotka.xenonx.domain.models.Genre
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.util.Constants.Companion.BASE_BACKDROP_IMAGE_URL
import org.lotka.xenonx.presentation.composable.StandardHeaderText
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall
@Composable
fun HeaderSection(
    images: List<Movies>,
    modifier: Modifier = Modifier
) {
    var currentIndex by remember { mutableIntStateOf(0) }


    if (images.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp),
            contentAlignment = Alignment.Center
        ) {
           Text(text = "OOps Image Is Null !!"
           , style = MaterialTheme.typography.h2,
               fontWeight = FontWeight.Bold
           )
        }
    } else {
        // Start the carousel only if images list is not empty
        LaunchedEffect(Unit) {
            while (true) {
                delay(6000L)
                currentIndex = (currentIndex + 1) % images.size
            }
        }

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
                    .clip(shape = RoundedCornerShape(Constants.SpaceMedium))
                    .shadow(elevation = 3.dp)
            ) {
                val imagePainter = rememberAsyncImagePainter(
                    model =  BASE_BACKDROP_IMAGE_URL +
                            images[currentIndex].backdropPath
                )

                Image(
                    painter = imagePainter,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(Constants.SpaceMedium)),
                    contentDescription = "header image"
                )

                Text(
                    text = images[currentIndex].title ?: "Title Of Image",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
            ) {
                images.forEachIndexed { index, _ ->
                    val size by animateDpAsState(
                        targetValue = if (index == currentIndex) 12.dp else 8.dp,
                        label = ""
                    )
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .size(size)
                            .clip(CircleShape)
                            .background(if (index == currentIndex) Color.White else Color.Gray)
                    )
                }
            }


        }
    }
}




@Composable
fun Geners(
    genre:List<Genre>,
    onNavigateTo:(String)->Unit ={}
){
    Column(modifier = Modifier.fillMaxWidth()) {

        StandardHeaderText(
            text = "Genres")
        Spacer(modifier = Modifier.height(SpaceSmall))
        LazyRow(modifier = Modifier.fillMaxWidth(),

            ) {
            genre?.let {
                items(it.size) {index->
                    if (index != 0) {
                        Spacer(modifier = Modifier.width(SpaceSmall))
                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(40.dp))
                            .background(color = MaterialTheme.colors.primary)
                            .clickable {
                                onNavigateTo(
                                    ScreensNavigation.genryVisyScreen.route
                                            + "/${genre[index].id}"
                                            + "/${genre[index].name}"
                                )

                            }
                    ) {

                            Text(
                                modifier = Modifier.padding(SpaceSmall)                        ,
                                text = it[index].name,
                                color = MaterialTheme.colors.onBackground,
                                fontWeight = FontWeight.Medium,
                                style = MaterialTheme.typography.body1,

                                )
                        }
                    }
                }
            }

        }
    }

