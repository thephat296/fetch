package com.vtp.fetch.presentation.reward

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.vtp.fetch.domain.model.Reward

@Composable
fun RewardListScreen(
    state: RewardUiState,
    onRewardClicked: (Reward) -> Unit
) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.rewards, key = Reward::id) { reward ->
                RewardItem(
                    reward = reward,
                    onItemClicked = onRewardClicked
                )
            }
        }
        state.error?.let {
            Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
