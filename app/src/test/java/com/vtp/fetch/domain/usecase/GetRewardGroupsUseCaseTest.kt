package com.vtp.fetch.domain.usecase

import com.vtp.fetch.data.repository.TestRewardRepository
import com.vtp.fetch.domain.model.Reward
import com.vtp.fetch.domain.model.RewardGroup
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class GetRewardGroupsUseCaseTest {

    private val rewardRepository = TestRewardRepository()
    private val useCase = GetRewardGroupsUseCase(rewardRepository)

    @Test
    fun `get reward groups, filter item without empty name, sort by group id then sort by reward name`() =
        runBlocking {
            rewardRepository.rewards = listOf(
                Reward(4, 2, "Item 4"),
                Reward(3, 1, ""),
                Reward(2, 3, null),
                Reward(1, 4, "Item 1"),
                Reward(5, 3, "Item 5"),
                Reward(7, 4, "Item 7"),
                Reward(6, 1, "Item 6"),
                Reward(8, 2, "Item 8"),
            )
            assertEquals(
                useCase().first(),
                listOf(
                    RewardGroup(id = 1, rewards = listOf(Reward(6, 1, "Item 6"))),
                    RewardGroup(
                        id = 2,
                        rewards = listOf(
                            Reward(4, 2, "Item 4"),
                            Reward(8, 2, "Item 8"),
                        )
                    ),
                    RewardGroup(id = 3, rewards = listOf(Reward(5, 3, "Item 5"))),
                    RewardGroup(
                        id = 4,
                        rewards = listOf(
                            Reward(1, 4, "Item 1"),
                            Reward(7, 4, "Item 7"),
                        )
                    )
                )
            )
        }
}