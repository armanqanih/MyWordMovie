package org.lotka.xenonx.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew

import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.util.Constants.SpaceLarge
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium
import org.lotka.xenonx.presentation.util.Constants.SpaceSmall
import org.lotka.xenonx.presentation.util.Constants.SpaceToLarge

@Composable
fun SearchScreen(
    onNavigateUp:()->Unit = {}
){
Column(modifier = Modifier.fillMaxSize()) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colors.surface),
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(onClick = {  onNavigateUp() }) {
            Icon(
                modifier = Modifier
                    .clip(shape = CircleShape)

                    .align(Alignment.CenterVertically)

                , imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "BackDetail",
                tint = MaterialTheme.colors.onBackground,
            )
        }
        var text by remember { mutableStateOf("") }
        androidx.compose.material.TextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface,
                disabledIndicatorColor = MaterialTheme.colors.surface,
                focusedIndicatorColor = MaterialTheme.colors.surface,
                unfocusedIndicatorColor = MaterialTheme.colors.surface
                ),
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {
                text=it
            },
            enabled = true,
            placeholder = {
                Text(text = "Search...",
                    style =  MaterialTheme.typography.body1)
            },

            textStyle = MaterialTheme.typography.body1,
            singleLine = true,
            shape = CircleShape,
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .padding(SpaceSmall)
                        .align(Alignment.CenterVertically)
                    , imageVector = Icons.Outlined.Cancel,
                    contentDescription = "BackDetail",
                    tint = MaterialTheme.colors.onBackground,
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .padding(SpaceSmall)
                        .align(Alignment.CenterVertically)
                    , imageVector = Icons.Default.Search,
                    contentDescription = "BackDetail",
                    tint = MaterialTheme.colors.onBackground,
                )
            }



        )

    }


    Spacer(modifier = Modifier.height(SpaceMedium))

    LazyColumn (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = SpaceSmall)
    ){

        items(10){
            Spacer(modifier = Modifier.height(SpaceMedium))
            Row (modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(SpaceMedium))
                .background(color = MaterialTheme.colors.surface),
                horizontalArrangement = Arrangement.Center
                ){

                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(SpaceMedium)),
                    painter = painterResource(id = R.drawable.pobg ),
                    contentDescription = "header image"
                )
                Spacer(modifier = Modifier.width(SpaceSmall))
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = SpaceToLarge)
                    ,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                    ){

                  
                    
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(SpaceSmall),
                        text = "The Son Of Super Man Super max ",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                      
                        color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body1,)

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(SpaceSmall),
                        text = "New Movies Coming ",
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.body2,)
                }


            }

        }



    }


}

}