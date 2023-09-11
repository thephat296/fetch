package com.vtp.fetch.data.repository

import com.vtp.fetch.domain.model.Reward
import com.vtp.fetch.domain.repository.RewardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TestRewardRepository : RewardRepository {

    var rewards: List<Reward>? = null
    override fun getRewards(): Flow<List<Reward>> = flowOf(rewards.orEmpty())
}
