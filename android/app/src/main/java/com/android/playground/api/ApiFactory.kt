package com.android.playground.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Factory class for creating the Retrofit instance.
 */
class ApiFactory(private val host: String = HOST) {
    fun create(): Api {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(host)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient)
            .build()
            .create(Api::class.java)
    }

    companion object {
        private const val TIMEOUT_SECONDS = 24L
        private const val HOST = "https://localhost:3000"
    }
}
