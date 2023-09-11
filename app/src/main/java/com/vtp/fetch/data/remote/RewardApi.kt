package com.vtp.fetch.data.remote

import retrofit2.http.GET

interface RewardApi {
    @GET("hiring.json")
    suspend fun getRewards(): List<RewardDto>
}
