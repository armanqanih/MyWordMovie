package org.lotka.xenonx.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.Constants.SpaceMedium


@Composable
fun StandardTopBar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit = {},
    showArrawBackIosNew: Boolean=false,
    showTopBarMenu : Boolean = false,
    showArrawBack: Boolean = false,
    title: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
){

    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = title,
        navigationIcon = {
            if (showArrawBackIosNew){
                IconButton(onClick = {
                    onNavigateUp()
                }) {
                    Icon(

                        imageVector =  Icons.Default.ArrowBackIosNew,
                        contentDescription = "ArrowBack" ,
                        tint = MaterialTheme.colors.onBackground,
                    )
                }

            }
            else null

            if (showArrawBack){
                IconButton(onClick = {
                    onNavigateUp()
                }) {
                    Icon(

                        imageVector =  Icons.Default.ArrowBack,
                        contentDescription = "ArrowBack" ,
                        tint = MaterialTheme.colors.onBackground,
                    )
                }

            }else null

            if (showTopBarMenu){
                Icon(
                    modifier = Modifier.clickable {
                        onNavigateUp()
                    }.padding(start = SpaceMedium),
                    imageVector =  Icons.Default.Menu,
                    contentDescription = "ArrowBack" ,
                    tint = MaterialTheme.colors.onBackground,
                )

            } else null


        },
        actions = actions,
        backgroundColor = MaterialTheme.colors.surface,

        )

}