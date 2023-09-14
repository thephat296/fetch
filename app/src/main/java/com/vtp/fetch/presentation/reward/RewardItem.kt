package com.vtp.fetch.presentation.reward

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vtp.fetch.R
import com.vtp.fetch.domain.model.Reward

@Composable
fun RewardItem(
    reward: Reward,
    onItemClicked: (Reward) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(5.dp)
            .clickable { onItemClicked(reward) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = stringResource(R.string.reward_list_id, reward.listId))
                Text(text = stringResource(R.string.reward_id, reward.id))
                Text(text = stringResource(R.string.reward_name, reward.name.orEmpty()))
            }
        }
    }
}
