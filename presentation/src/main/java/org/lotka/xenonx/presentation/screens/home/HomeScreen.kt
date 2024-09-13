package org.lotka.xenonx.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.presentation.composable.StandardToolBar
import org.lotka.xenonx.presentation.screens.home.compose.HeaderSeaction
import org.lotka.xenonx.presentation.screens.home.compose.MiddleSeaction
import org.lotka.xenonx.presentation.util.Constants

@Composable
fun HomeScreen() {

    Column(modifier = Modifier.fillMaxSize()

    ) {

        StandardToolBar(
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
            icon = Icons.Filled.Menu,
            title = {
                Text(text = "Home Movie",
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Bold
                    )
            },
            navAction = {
                IconButton(onClick = { /* First action */ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
                    Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Outlined.Bookmarks,
                        contentDescription = "bookMarks",
                        tint = MaterialTheme.colors.onBackground
                    )
                }

            }



        )
        LazyColumn (modifier = Modifier
            .fillMaxSize()
            .padding(Constants.SpaceMedium)
        ){
            item{
             HeaderSeaction()
            }
            item{
                Spacer(modifier = Modifier.height(Constants.SpaceMedium))
                MiddleSeaction()
            }
//            item{
//                BottomSeaction()
//        }


    }


}}