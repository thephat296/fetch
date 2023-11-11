package com.vtp.fetch.domain.usecase

import app.cash.turbine.test
import com.vtp.fetch.data.repository.FakeRewardRepository
import com.vtp.fetch.domain.testdata.rewardsResultData
import com.vtp.fetch.domain.testdata.rewardsTestData
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class GetRewardsUseCaseTest {

    private val rewardRepository = FakeRewardRepository()
    private val useCase = GetRewardsUseCase(rewardRepository)

    @Test
    fun `get reward groups, filter item without empty name, sort by group id then sort by reward name`() =
        runTest {
            useCase().test {
                rewardRepository.emit(rewardsTestData)
                assertEquals(awaitItem(), rewardsResultData)
            }
        }
}