package com.vtp.fetch.di

import com.vtp.fetch.di.qualifier.DefaultDispatcher
import com.vtp.fetch.di.qualifier.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
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