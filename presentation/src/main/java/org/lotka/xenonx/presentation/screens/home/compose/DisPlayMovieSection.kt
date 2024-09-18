package org.lotka.xenonx.presentation.screens.home.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.composable.StandardHeaderText
import org.lotka.xenonx.presentation.composable.StandardTextMore
import org.lotka.xenonx.presentation.util.Constants
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall

@Composable
fun DisPlayMovieSection(
    movies:List<String> = emptyList(),
    onNavigateTo:()->Unit={}
){
    Column(modifier = Modifier.fillMaxWidth()){

        //Discover Movie
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
        ){
            StandardHeaderText(
                modifier = Modifier.weight(8f),
                text = "Discover Movie",
                showIcon = true,
                colorIcon = MaterialTheme.colors.secondary,
                iconImage = Icons.Default.Star
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
                Spacer(modifier = Modifier.width(SpaceSmall))
                    Image(
                        modifier = Modifier
                            .height(120.dp)
                            .width(230.dp)
                            .clip(shape = RoundedCornerShape(Constants.SpaceMedium))
                            .clickable { onNavigateTo() }
                            .shadow(elevation = 4.dp),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.tombreader ),
                        contentDescription = "header image"

                    )
            }
        }



    }

}