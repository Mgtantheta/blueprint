package com.mgtantheta.blueprint.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

data class HomeUiState(
    val userName: String = "Mgtantheta",
    val avatarUrl: String = "https://github.com/Mgtantheta.png",
)

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    modifier: Modifier = Modifier,
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            AsyncImage(
                model = uiState.avatarUrl,
                contentDescription = "GitHub Avatar",
                modifier =
                    Modifier
                        .size(120.dp)
                        .clip(CircleShape),
            )
            Text(text = "Hello ${uiState.userName}!")
        }
    }
}

private class HomeUiStatePreviewParameterProvider : PreviewParameterProvider<HomeUiState> {
    override val values: Sequence<HomeUiState> =
        sequenceOf(
            HomeUiState(),
            HomeUiState(userName = "Android", avatarUrl = ""),
        )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview(
    @PreviewParameter(HomeUiStatePreviewParameterProvider::class) uiState: HomeUiState,
) {
    HomeScreen(uiState = uiState)
}
