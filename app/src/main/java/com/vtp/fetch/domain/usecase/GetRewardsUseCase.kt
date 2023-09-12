package com.vtp.fetch.domain.usecase

import com.vtp.fetch.domain.model.Reward
import com.vtp.fetch.domain.repository.RewardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRewardsUseCase @Inject constructor(
    private val repository: RewardRepository
) {
    operator fun invoke(): Flow<List<Reward>> {
        return repository.getRewards()
            .map { rewards ->
                rewards.asSequence()
                    .filter { !it.name.isNullOrEmpty() }
                    .sortedWith(compareBy({ it.listId }, { it.name }))
                    .toList()
            }
    }
}