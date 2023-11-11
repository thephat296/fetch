package com.vtp.fetch.presentation.deprecated

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vtp.fetch.databinding.ActivityRewardsBinding
import com.vtp.fetch.presentation.deprecated.utils.toast
import com.vtp.fetch.presentation.reward.RewardViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RewardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRewardsBinding

    private val viewModel: RewardViewModel by viewModels()

    @Inject
    internal lateinit var rewardAdapter: RewardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding.rvRewardGroup) {
            adapter = rewardAdapter
            layoutManager = LinearLayoutManager(this@RewardActivity)
        }
        lifecycleScope.launch {
            viewModel.rewardUiState
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    rewardAdapter.submitList(it.rewards)
                    binding.progressCircular.isVisible = it.isLoading
                    it.error?.let { throwable ->
                        toast(throwable.message.orEmpty())
                    }
                }
        }
    }
}