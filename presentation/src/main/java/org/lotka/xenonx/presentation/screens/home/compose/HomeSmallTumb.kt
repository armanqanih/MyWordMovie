package org.lotka.xenonx.presentation.screens.home.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation
import org.lotka.xenonx.presentation.util.Constants

@Composable
fun HomeSmallThumb(
    imageUrl:String,
    onNavigateTo:()->Unit = {},
){

 if (imageUrl != null){
     Box(modifier = Modifier
         .height(150.dp)
         .width(120.dp)
         .clip(shape = RoundedCornerShape(Constants.SpaceMedium))
         .shadow(elevation = 4.dp)
         .clickable {
             onNavigateTo()
         }
     ) {

         Image(
             contentScale = ContentScale.Crop,
             modifier = Modifier
                 .fillMaxSize()
                 .clip(RoundedCornerShape(Constants.SpaceMedium)),
             painter = rememberAsyncImagePainter(
                 ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                     .apply(block = fun ImageRequest.Builder.() {
                         size(Size.ORIGINAL)
                         scale(Scale.FILL)
                         crossfade(true)
                     }).build()
             ),
             contentDescription = "header image"

         )
     }
 }
    else{
     Image(
         contentScale = ContentScale.Crop,
         modifier = Modifier
             .fillMaxSize()
             .clip(RoundedCornerShape(Constants.SpaceMedium)),
         painter = painterResource(id = R.drawable.ic_broken_image),
         contentDescription = "header image"

     )
 }


}