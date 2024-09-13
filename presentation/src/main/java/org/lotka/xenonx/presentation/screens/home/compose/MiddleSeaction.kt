package org.lotka.xenonx.presentation.screens.home.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.composable.StandardHeaderText
import org.lotka.xenonx.presentation.composable.StandardTextMore
import org.lotka.xenonx.presentation.util.Constants

@Composable
fun MiddleSeaction(){
    Column(modifier = Modifier.fillMaxWidth()){

//        Play Now

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
            ){
            StandardHeaderText(
                modifier = Modifier.weight(6f),
                text = "Play Now",)
            StandardTextMore(
                modifier = Modifier.weight(2f),
                onClick = {

                }
            )
        }

        Spacer(modifier = Modifier.height(Constants.SpaceMedium))

        LazyRow(modifier = Modifier.fillMaxWidth()){
            items(10){
                if (it!=0){
                    Spacer(modifier = Modifier.width(Constants.SpaceSmall))
                }
                Box(modifier = Modifier
                    .height(150.dp)
                    .width(120.dp)
                    .clip(shape = RoundedCornerShape(Constants.SpaceMedium))
                    .shadow(elevation = 4.dp)
                ){

                    Image(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(Constants.SpaceMedium)),
                        painter = painterResource(id = R.drawable.pobg ),
                        contentDescription = "header image"

                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(Constants.SpaceMedium))
         // Popular Movie

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
        ){
            StandardHeaderText(
                modifier = Modifier.weight(6f),
                text = "Popular Movie",
                showIcon = true,
                iconImage = Icons.Default.QuestionMark
                )
            StandardTextMore(
                modifier = Modifier.weight(2f),
                onClick = {

                }
            )
        }

        Spacer(modifier = Modifier.height(Constants.SpaceMedium))

        LazyRow(modifier = Modifier.fillMaxWidth()){
            items(10){
                if (it!=0){
                    Spacer(modifier = Modifier.width(Constants.SpaceSmall))
                }
                Box(modifier = Modifier
                    .height(150.dp)
                    .width(120.dp)
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
                }
            }
        }

    }

}