package com.vtp.fetch.presentation.deprecated

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vtp.fetch.R
import com.vtp.fetch.databinding.ItemRewardBinding
import com.vtp.fetch.domain.model.Reward
import javax.inject.Inject

class RewardAdapter @Inject constructor() :
    ListAdapter<Reward, RewardAdapter.ViewHolder>(RewardDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRewardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reward = getItem(position)
        with(holder.binding) {
            tvListId.text = root.context.getString(R.string.reward_list_id, reward.listId)
            tvId.text = root.context.getString(R.string.reward_id, reward.id)
            tvName.text = root.context.getString(R.string.reward_name, reward.name)
        }
    }

    class ViewHolder(val binding: ItemRewardBinding) : RecyclerView.ViewHolder(binding.root)

    private class RewardDiffCallBack : DiffUtil.ItemCallback<Reward>() {
        override fun areItemsTheSame(oldItem: Reward, newItem: Reward): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Reward, newItem: Reward): Boolean {
            return oldItem == newItem
        }
    }
}