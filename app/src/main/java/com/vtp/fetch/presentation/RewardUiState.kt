package com.vtp.fetch.presentation

import com.vtp.fetch.domain.model.RewardGroup

data class RewardUiState(
    val isLoading: Boolean = false,
    val rewardGroups: List<RewardGroup> = emptyList(),
    val error: Throwable? = null
)