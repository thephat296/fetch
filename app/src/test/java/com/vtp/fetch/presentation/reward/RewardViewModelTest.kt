package com.vtp.fetch.presentation.reward

import app.cash.turbine.test
import com.vtp.fetch.data.repository.FakeRewardRepository
import com.vtp.fetch.domain.testdata.rewardsResultData
import com.vtp.fetch.domain.testdata.rewardsTestData
import com.vtp.fetch.domain.usecase.GetRewardsUseCase
import com.vtp.fetch.presentation.MainDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RewardViewModelTest {
    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val rewardRepository = FakeRewardRepository()
    private lateinit var viewModel: RewardViewModel

    @Before
    fun setup() {
        viewModel = RewardViewModel(GetRewardsUseCase(rewardRepository))
    }

    @Test
    fun getRewardUiState() = runTest {
        viewModel.rewardUiState.test {
            assert(awaitItem() == RewardUiState(isLoading = true))
            rewardRepository.emit(rewardsTestData)
            assert(awaitItem() == RewardUiState(rewards = rewardsResultData))
        }
    }
}