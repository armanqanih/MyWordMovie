package org.lotka.xenonx.presentation.screens.detail

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp

import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.screens.detail.compose.MovieInformation

import org.lotka.xenonx.presentation.screens.detail.compose.TypeOfMovie
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.Constants.SpaceLarge
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall
import org.lotka.xenonx.presentation.util.Constants.SpaceToLarge

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailScreen(
  onNavigateUp:()-> Unit

) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(bottom = SpaceMedium),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(SpaceMedium))
            ) {


                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    painter = painterResource(id = R.drawable.assasin),
                    contentDescription = "Detail Header image"
                )
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .offset(y = (+90).dp)
                        .align(Alignment.BottomCenter)
                        .clip(RoundedCornerShape(Constants.SpaceSmall))
                        .shadow(elevation = 1.dp)
                        .width(150.dp)
                        .height(300.dp),
                    painter = painterResource(id = R.drawable.pobg),
                    contentDescription = "profile image"
                )

                // Row with icons (On top of the images)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter) // Align to the top center of the Box
                        .padding(Constants.SpaceMedium),
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
                text = "The Son Of Super Man",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

        }

// Type Of Movie
        item() {
            Spacer(modifier = Modifier.height(SpaceSmall))
            TypeOfMovie(
                eachItem = 2,
                text = "Action"
            )


        }
        item {

            Spacer(modifier = Modifier.height(SpaceSmall))
            MovieInformation(
                ReleaseDate = "2022",
                Duration ="120 min",
                Rating = "4.5",
                Language = "English")


        }

//        Cast

        item {

            Spacer(modifier = Modifier.height(SpaceLarge))

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = SpaceToLarge),
            ) {
                Text(
                    text = "Cast",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
            LazyRow (horizontalArrangement = Arrangement.spacedBy(SpaceSmall)){
                items(10){
                    Box(modifier = Modifier
                        .height(160.dp)
                        .width(120.dp)
                        .clip(shape = RoundedCornerShape(SpaceMedium))
                        .shadow(elevation = 4.dp)
                    ){

                        Image(
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(SpaceMedium)),
                            painter = painterResource(id = R.drawable.tombreader),
                            contentDescription = "header image"

                        )
                        Text(
                            modifier = Modifier.fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .padding(SpaceSmall),
                            text = "New Movies Coming ",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.onBackground,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.body2,


                            )
                }}

        }
            }

            }


// Similar Movies
        item {

            Spacer(modifier = Modifier.height(SpaceLarge))

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = SpaceToLarge),
            ) {
                Text(
                    text = "Similar Movies",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                LazyRow (horizontalArrangement = Arrangement.spacedBy(SpaceSmall)){
                    items(10){
                        Box(modifier = Modifier
                            .height(160.dp)
                            .width(120.dp)
                            .clip(shape = RoundedCornerShape( SpaceMedium))
                            .shadow(elevation = 4.dp)
                        ){

                            Image(
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(SpaceMedium)),
                                painter = painterResource(id = R.drawable.prettygirl),
                                contentDescription = "header image"

                            )

                        }}

                }

            }


        }}

    }





//

