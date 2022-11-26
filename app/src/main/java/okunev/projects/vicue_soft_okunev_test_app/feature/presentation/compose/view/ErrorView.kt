package okunev.projects.vicue_soft_okunev_test_app.feature.presentation.compose.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import okunev.projects.vicue_soft_okunev_test_app.R
import okunev.projects.vicue_soft_okunev_test_app.core.theme.Theme
import okunev.projects.vicue_soft_okunev_test_app.feature.presentation.viewmodel.models.MainEvent

@Composable
fun ErrorView(eventHandler: (MainEvent) -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Card(shape = Theme.shapes.large) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(id = R.string.smth_wrong))
                Button(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(Theme.shapes.medium),
                    onClick = { eventHandler(MainEvent.OnRetryClick) }) {
                    Text(text = stringResource(id = R.string.try_again))
                }
            }
        }
    }
}