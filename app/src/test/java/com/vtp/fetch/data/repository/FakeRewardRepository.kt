package com.vtp.fetch.data.repository

import com.vtp.fetch.domain.model.Reward
import com.vtp.fetch.domain.repository.RewardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class FakeRewardRepository : RewardRepository {
    private val flow = MutableSharedFlow<List<Reward>>()
    suspend fun emit(value: List<Reward>) = flow.emit(value)
    override fun getRewards(): Flow<List<Reward>> = flow
}
