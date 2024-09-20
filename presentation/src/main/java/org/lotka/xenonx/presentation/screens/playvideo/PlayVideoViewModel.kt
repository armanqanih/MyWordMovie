package org.lotka.xenonx.presentation.screens.playvideo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.lotka.xenonx.domain.models.VideoData
import org.lotka.xenonx.domain.usecase.play_video.InitializePlayerUseCae
import org.lotka.xenonx.domain.usecase.play_video.PlayVideoUseCase
import org.lotka.xenonx.domain.usecase.play_video.PlayViewBuilderUseCase
import org.lotka.xenonx.domain.usecase.play_video.ReleasePlayerUserCae
import javax.inject.Inject

@HiltViewModel
class PlayVideoViewModel @Inject constructor(
    private val initializePlayerUseCae: InitializePlayerUseCae,
    private val playVideoUseCase: PlayVideoUseCase,
    private val playViewBuilderUseCase: PlayViewBuilderUseCase,
    private val releasePlayerUseCase : ReleasePlayerUserCae
):ViewModel() {


    private val _state = MutableStateFlow(VideoPlayState())
    val state = _state.asStateFlow()


    fun initializePlayer() {
        state.value.context?.let { initializePlayerUseCae.invoke(it) }
    }

    fun releasePlayer() {
        releasePlayerUseCase.invoke(state.value.exoPlayer)
    }

    fun playVideo() {
        state.value.videoList?.let { playVideoUseCase.invoke(state.value.exoPlayer, it) }
    }

    fun playerViewBuilder() {
        state.value.context?.let { playViewBuilderUseCase.invoke(it, state.value.exoPlayer) }
    }
}
