package com.vtp.fetch.domain.testdata

import com.vtp.fetch.domain.model.Reward

val rewardsTestData = listOf(
    Reward(4, 2, "Item 4"),
    Reward(3, 1, ""),
    Reward(2, 3, null),
    Reward(1, 4, "Item 1"),
    Reward(5, 3, "Item 5"),
    Reward(7, 4, "Item 7"),
    Reward(6, 1, "Item 6"),
    Reward(8, 2, "Item 8"),
)

val rewardsResultData = listOf(
    Reward(6, 1, "Item 6"),
    Reward(4, 2, "Item 4"),
    Reward(8, 2, "Item 8"),
    Reward(5, 3, "Item 5"),
    Reward(1, 4, "Item 1"),
    Reward(7, 4, "Item 7")
)