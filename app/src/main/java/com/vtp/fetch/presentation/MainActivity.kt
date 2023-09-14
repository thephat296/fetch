package com.vtp.fetch.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.vtp.fetch.presentation.theme.FetchTheme
import com.vtp.fetch.presentation.reward.RewardListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchTheme {
                RewardListScreen()
            }
        }
    }
}