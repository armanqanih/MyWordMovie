package org.lotka.xenonx.domain.usecase.play_video

import android.content.Context
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.models.Movies
import org.lotka.xenonx.domain.repository.PlayVideoRepository
import javax.inject.Inject


class InitializePlayerUseCae @Inject constructor(
   val repository: PlayVideoRepository
){
    operator fun invoke(context: Context )  {
        return repository.initializePlayer(context)
    }
}