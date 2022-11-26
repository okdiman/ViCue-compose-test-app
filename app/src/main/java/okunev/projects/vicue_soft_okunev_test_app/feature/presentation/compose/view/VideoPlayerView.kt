package okunev.projects.vicue_soft_okunev_test_app.feature.presentation.compose.view

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models.MainState

@Composable
fun VideoPlayerView(state: MainState) {
    val context = LocalContext.current
    val defaultDataSourceFactory = DefaultDataSource.Factory(context)
    val dataSourceFactory = DefaultDataSource.Factory(
        context,
        defaultDataSourceFactory
    )
    val exoPlayer = remember {
        ExoPlayer.Builder(context)
            .build().apply {
                playWhenReady = true
                videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
                repeatMode = Player.REPEAT_MODE_ALL
            }
    }.apply {
        val source = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(state.selectedVideoUrl))
        setMediaSource(source)
        prepare()
    }

    DisposableEffect(
        AndroidView(factory = {
            PlayerView(it).apply {
                hideController()
                useController = false
                setShowBuffering(PlayerView.SHOW_BUFFERING_ALWAYS)
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                player = exoPlayer
                layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        })
    ) {
        onDispose {
            exoPlayer.release()
        }
    }
}