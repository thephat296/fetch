package com.vtp.fetch.di

import com.vtp.fetch.data.remote.RewardApi
import com.vtp.fetch.data.repository.DefaultRewardRepository
import com.vtp.fetch.domain.repository.RewardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
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

fun main() = runBlocking {
    val result1 = async {
        performTask1()
    }
    val result2 = async {
        performTask2()
    }
    // Use await() to wait for both results
    println("Result 1: ${result1.await()}")
    println("Result 2: ${result2.await()}")
}
suspend fun performTask1(): Int {
    delay(1000L)  // Simulating a long-running task
    return 10
}
suspend fun performTask2(): Int {
    delay(2000L)  // Simulating another long-running task
    return 20
}
