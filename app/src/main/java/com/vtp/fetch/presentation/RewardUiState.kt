package com.vtp.fetch.presentation

import com.vtp.fetch.domain.model.Reward

data class RewardUiState(
    val isLoading: Boolean = false,
    val rewardGroups: List<Reward> = emptyList(),
    val error: Throwable? = null
)