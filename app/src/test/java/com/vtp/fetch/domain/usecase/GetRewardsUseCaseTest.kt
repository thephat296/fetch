package com.vtp.fetch.domain.usecase

import com.vtp.fetch.data.repository.TestRewardRepository
import com.vtp.fetch.domain.model.Reward
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class GetRewardsUseCaseTest {

    private val rewardRepository = TestRewardRepository()
    private val useCase = GetRewardsUseCase(rewardRepository)

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
                    Reward(6, 1, "Item 6"),
                    Reward(4, 2, "Item 4"),
                    Reward(8, 2, "Item 8"),
                    Reward(5, 3, "Item 5"),
                    Reward(1, 4, "Item 1"),
                    Reward(7, 4, "Item 7")
                )
            )
        }
}