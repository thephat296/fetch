package com.vtp.fetch.data.remote

import com.vtp.fetch.domain.model.Reward

fun RewardDto.toReward() = Reward(
    id = id,
    listId = listId,
    name = name
)
