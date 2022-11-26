package okunev.projects.vicue_soft_okunev_test_app.feature.presentation.compose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlin.math.roundToInt
import okunev.projects.vicue_soft_okunev_test_app.R
import okunev.projects.vicue_soft_okunev_test_app.core.theme.Theme
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models.MainEvent
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models.MainState

@Composable
fun SuccessView(state: MainState, eventHandler: (event: MainEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        var maxX by remember { mutableStateOf(0f) }
        var maxY by remember { mutableStateOf(0f) }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .padding(8.dp)
                .clip(Theme.shapes.large)
                .onSizeChanged {
                    maxX = it.width.toFloat()
                    maxY = it.height.toFloat()
                }
        ) {
            VideoPlayerView(state)
            if (state.isTextFieldVisible) {
                var offsetX by remember { mutableStateOf(0f) }
                var offsetY by remember { mutableStateOf(0f) }
                TextField(
                    modifier = Modifier
                        .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                        .fillMaxWidth(0.4f)
                        .pointerInput(Unit) {
                            detectDragGestures { change, dragAmount ->
                                change.consume()
                                val newX = offsetX + dragAmount.x
                                val newY = offsetY + dragAmount.y
                                if (newX in 0f..maxX) {
                                    offsetX += dragAmount.x
                                }
                                if (newY in 0f..maxY) {
                                    offsetY += dragAmount.y
                                }
                            }
                        }
                        .clip(Theme.shapes.large)
                        .onSizeChanged {
                            maxX -= it.width
                            maxY -= it.height
                        },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.welcome),
                            color = Theme.colors.hintColor
                        )
                    },
                    value = state.text,
                    textStyle = TextStyle.Default.copy(fontSize = 24.sp),
                    onValueChange = { eventHandler(MainEvent.OnTextChanged(it)) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Theme.colors.textSecondaryColor,
                        backgroundColor = Theme.colors.primaryBackgroundColor.copy(alpha = 0.5f),
                        focusedIndicatorColor = Theme.colors.textSecondaryColor,
                        unfocusedIndicatorColor = Theme.colors.textSecondaryColor,
                        cursorColor = Theme.colors.textSecondaryColor
                    ),
                    singleLine = true,
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.clickable {
                                eventHandler(MainEvent.OnClearTextClick)
                            },
                            imageVector = Icons.Outlined.Clear,
                            contentDescription = "Clear text field"
                        )
                    }
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(
                onClick = {
                    eventHandler(MainEvent.OnShowButtonClick)
                },
                modifier = Modifier
                    .padding(top = 44.dp)
                    .width(144.dp)
                    .height(46.dp)
                    .clip(Theme.shapes.small)
                    .background(Theme.colors.primaryColor)
            ) {
                Text(
                    text = stringResource(id = R.string.text_button),
                    fontSize = 16.sp,
                    color = Theme.colors.textPrimaryColor
                )
            }
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            items(state.items) { video ->
                AsyncImage(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(70.dp)
                        .clip(Theme.shapes.small)
                        .clickable {
                            eventHandler(MainEvent.OnPosterClick(video.videoUrl))
                        },
                    model = video.posterUrl,
                    contentDescription = "poster",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_outline_cloud_download),
                    error = painterResource(id = R.drawable.ic_outline_sync_problem)
                )
            }
        }
    }
}