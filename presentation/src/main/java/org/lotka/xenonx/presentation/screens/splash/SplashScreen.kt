package org.lotka.xenonx.presentation.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController

import kotlinx.coroutines.delay
import org.lotka.xenonx.presentation.R
import org.lotka.xenonx.presentation.ui.navigation.ScreensNavigation

@Composable
fun SplashScreen(
    onNavigate:(String)->Unit,

) {

    var progress by remember { mutableStateOf(0f) }
    val animationDuration = 3000 // 3 seconds
    val splashDuration = 3000L // 3 seconds should same for animationDuration
    val scale = remember {
        Animatable(0f)
    }
    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 2000,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        progress = 1f
        delay(splashDuration)
        onNavigate(ScreensNavigation.homeScreen.route)

        }


    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .scale(scale.value)
                .align(Alignment.CenterHorizontally) // Align horizontally to center
        )
        Spacer(modifier = Modifier.height(16.dp))

        AnimatedProgressBar(progress = progress, animationDuration = animationDuration)
    }


}

@Composable
fun AnimatedProgressBar(progress: Float, animationDuration: Int) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec =  tween(durationMillis = animationDuration), label = ""
    )
    LinearProgressIndicator(
        progress = { animatedProgress },
        color = androidx.compose.material.MaterialTheme.colors.primary,//progress Color
        trackColor = MaterialTheme.colorScheme.primary,//
        modifier = Modifier
            .height(15.dp)
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(40))
    )
}