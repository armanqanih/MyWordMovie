package org.lotka.xenonx.presentation.screens.playvideo

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import org.lotka.xenonx.domain.models.VideoData
import org.lotka.xenonx.domain.models.VideoList


data class VideoPlayState (
    var exoPlayer: ExoPlayer? = null,
     val context: Context?=null ,
    var videoList:  VideoList? = null
)