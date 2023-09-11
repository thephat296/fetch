package com.vtp.fetch.domain.repository

import com.vtp.fetch.domain.model.Reward
import kotlinx.coroutines.flow.Flow

interface RewardRepository {
    fun getRewards(): Flow<List<Reward>>
}