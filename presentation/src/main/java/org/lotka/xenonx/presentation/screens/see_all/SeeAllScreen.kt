package org.lotka.xenonx.presentation.screens.see_all

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.composable.StandardToolBar
import org.lotka.xenonx.presentation.util.Constants.SpaceLarge
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SeeAllScreen(
      onNavigateUp:()->Unit={}
) {

    Column(modifier = Modifier.fillMaxSize()) {
            StandardToolBar(
                modifier = Modifier.fillMaxWidth(),
                onNavigateUp = onNavigateUp,
                showBackArrow = true,
                title = {
                    Text(
                        text = "                Popular Movie",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold
                    )
                },
                navAction = {

                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = { }) {
                        Icon(
                            modifier = Modifier.clickable {

                            },
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "bookMarks",
                            tint = MaterialTheme.colors.onBackground
                        )
                    }

                }


            )





        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 3 items per row
            modifier = Modifier
                .fillMaxSize()

                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(20) { index -> // Adjust the item count as needed

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(shape = RoundedCornerShape(SpaceMedium))
                        .shadow(elevation = 4.dp)
                        .background(color = MaterialTheme.colors.surface),
                ) {
                    Image(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .clip(RoundedCornerShape(SpaceMedium)),
                        painter = painterResource(id = R.drawable.tombreader),
                        contentDescription = "header image"

                    )
                    Column (modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = SpaceSmall)
                        .align(Alignment.BottomCenter),

                        ){
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                ,
                            text = "New Movie  ",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.onBackground,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.body2,


                            )
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
                                text = "7.5",
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

        }}

}


