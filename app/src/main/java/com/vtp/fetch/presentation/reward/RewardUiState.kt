package com.vtp.fetch.presentation.reward

import com.vtp.fetch.domain.model.Reward

data class RewardUiState(
    val isLoading: Boolean = false,
    val rewards: List<Reward> = emptyList(),
    val error: Throwable? = null
)