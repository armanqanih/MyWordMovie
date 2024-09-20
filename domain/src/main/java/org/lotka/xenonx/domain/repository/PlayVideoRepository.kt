package org.lotka.xenonx.domain.repository

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.VideoList
import org.lotka.xenonx.domain.util.Resource

interface PlayVideoRepository {

     fun initializePlayer(context: Context)
     fun playerViewBuilder(context: Context, exoPlayer: ExoPlayer?): PlayerView
     fun releasePlayer(exoPlayer: ExoPlayer?)
     fun playVideo(exoPlayer: ExoPlayer?,videoList : VideoList)

}