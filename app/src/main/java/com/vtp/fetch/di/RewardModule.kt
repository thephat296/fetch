package com.vtp.fetch.di

import com.vtp.fetch.data.remote.RewardApi
import com.vtp.fetch.data.repository.DefaultRewardRepository
import com.vtp.fetch.domain.repository.RewardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object RewardModule {
    @Provides
    fun provideRewardApi(retrofit: Retrofit): RewardApi = retrofit.create(RewardApi::class.java)

    @Provides
    fun provideRewardRepository(
        rewardApi: RewardApi
    ): RewardRepository = DefaultRewardRepository(rewardApi)
}
