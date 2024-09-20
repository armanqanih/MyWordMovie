package org.lotka.xenonx.domain.usecase.play_video

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.models.VideoList
import org.lotka.xenonx.domain.repository.PlayVideoRepository
import javax.inject.Inject


class PlayVideoUseCase @Inject constructor(
   val repository: PlayVideoRepository
){
    operator fun invoke(exoPlayer: ExoPlayer?, videoList : VideoList)  {
        return repository.playVideo(exoPlayer,videoList)
    }
}