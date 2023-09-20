package com.vtp.fetch.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vtp.fetch.presentation.reward.RewardListScreen
import com.vtp.fetch.presentation.reward.RewardViewModel
import com.vtp.fetch.presentation.theme.FetchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchTheme {
                val viewModel: RewardViewModel = hiltViewModel()
                val state by viewModel.rewardUiState.collectAsStateWithLifecycle()
                RewardListScreen(
                    state = state,
                    onRewardClicked = {}
                )
            }
        }
    }
}