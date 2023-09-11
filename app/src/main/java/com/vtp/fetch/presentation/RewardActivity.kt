package com.vtp.fetch.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vtp.fetch.databinding.ActivityRewardsBinding
import com.vtp.fetch.presentation.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RewardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRewardsBinding

    private val viewModel: RewardViewModel by viewModels()

    @Inject
    internal lateinit var rewardGroupAdapter: RewardGroupAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding.rvRewardGroup) {
            adapter = rewardGroupAdapter
            layoutManager = LinearLayoutManager(this@RewardActivity)
            setHasFixedSize(true)
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.rewardUiState.collect {
                    rewardGroupAdapter.submitList(it.rewardGroups)
                    binding.progressCircular.isVisible = it.isLoading
                    it.error?.let { throwable ->
                        toast(throwable.message.orEmpty())
                    }
                }
            }
        }
    }
}