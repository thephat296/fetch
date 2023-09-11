package com.vtp.fetch.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vtp.fetch.R
import com.vtp.fetch.databinding.ItemRewardGroupBinding
import com.vtp.fetch.domain.model.RewardGroup
import javax.inject.Inject

class RewardGroupAdapter @Inject constructor(
    private val rewardAdapter: RewardAdapter
) : ListAdapter<RewardGroup, RewardGroupAdapter.ViewHolder>(RewardGroupDiffCallBack()) {

    private val pool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRewardGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, rewardAdapter, pool)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).id
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rewardGroup = getItem(position)
        with(holder) {
            binding.tvListId.text =
                binding.root.context.getString(R.string.reward_list_id, rewardGroup.id)
            rewardAdapter.submitList(rewardGroup.rewards)
        }
    }

    class ViewHolder(
        val binding: ItemRewardGroupBinding,
        val rewardAdapter: RewardAdapter,
        private val pool: RecyclerView.RecycledViewPool
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            with(binding.rvReward) {
                adapter = rewardAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                setRecycledViewPool(pool)
            }
        }
    }

    private class RewardGroupDiffCallBack : DiffUtil.ItemCallback<RewardGroup>() {
        override fun areItemsTheSame(oldItem: RewardGroup, newItem: RewardGroup): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RewardGroup, newItem: RewardGroup): Boolean {
            return oldItem == newItem
        }
    }
}