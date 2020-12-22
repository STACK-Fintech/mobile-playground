package com.android.playground.api

import com.android.playground.models.Transaction
import com.android.playground.models.User
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @GET("transactions")
    suspend fun getTransactions(): Response<List<Transaction>>
}
