package org.lotka.xenonx.presentation.screens.home.compose

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.composable.StandardHeaderText
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall

@Composable
fun HeaderSeaction(){

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(230.dp)
        .clip(shape = RoundedCornerShape(Constants.SpaceMedium))
        .shadow(elevation = 4.dp)
       ){

        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(Constants.SpaceMedium)),
            painter = painterResource(id = R.drawable.assasin ),
            contentDescription = "header image"

            )

        Text(
            text = "Title Of Image",
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )

        }
        Row(
            horizontalArrangement = Arrangement.Absolute.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
        ) {
                Box(
                    modifier = Modifier
                        .padding(Constants.SpaceSmall)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.White)

                )
            }
           Spacer(modifier = Modifier.height(Constants.SpaceSmall))
           Geners()

        }

    }


@Composable
fun Geners(){
    Column(modifier = Modifier.fillMaxWidth()) {

        StandardHeaderText(text = "Genres")
        Spacer(modifier = Modifier.height(Constants.SpaceSmall))
        LazyRow(modifier = Modifier.fillMaxWidth(),

            ) {
            items(10) {index->
                if (index != 0) {
                    Spacer(modifier = Modifier.width(SpaceSmall))
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.
                        clip(shape = RoundedCornerShape(40.dp)).
                    background(color = MaterialTheme.colors.primary)
                ) {
                    Text(
                        modifier = Modifier.padding(SpaceSmall),
                        text = "Actions",
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.body1,

                        )
                }
            }

        }
    }
}
