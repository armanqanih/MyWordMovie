package org.lotka.xenonx.data.remote.repository

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_USER
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE
import android.net.Uri
import androidx.annotation.OptIn
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import org.lotka.xenonx.domain.models.VideoList
import org.lotka.xenonx.domain.repository.PlayVideoRepository

@OptIn(UnstableApi::class)
class PlayVideoRepositoryImpl(

): PlayVideoRepository {
    override fun initializePlayer(context: Context) {
       ExoPlayer.Builder(context).build()
    }

     override fun playerViewBuilder(context: Context, exoPlayer: ExoPlayer?): PlayerView {
        val activity = context as Activity
        val playerView = PlayerView(context).apply {
            player = exoPlayer
            controllerAutoShow = true
            keepScreenOn = true
            setFullscreenButtonClickListener { isFullScreen ->
                if (isFullScreen){
                    activity.requestedOrientation = SCREEN_ORIENTATION_USER_LANDSCAPE
                }else{
                    activity.requestedOrientation = SCREEN_ORIENTATION_USER
                }
            }
        }
        return playerView
    }

    override fun releasePlayer(exoPlayer: ExoPlayer?) {
        exoPlayer?.playWhenReady = false
        exoPlayer?.release()

    }

    override fun playVideo(exoPlayer: ExoPlayer?,videoList : VideoList) {
        var index : Int = 0
        exoPlayer?.let { player ->
            player.apply {
                stop()
                clearMediaItems()
                setMediaItem(MediaItem.fromUri(Uri.parse(videoList.mainVideoList[index].videoUrl)))
                playWhenReady = true
                prepare()
                play()
            }
        }
    }

}