package com.android.playground.api

import com.android.playground.models.Transaction
import com.android.playground.models.User
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @GET("users")
    fun getUsersRx(): Single<List<User>>

    @GET("users")
    fun getUsersCall(): Call<List<User>>

    @GET("transactions")
    suspend fun getTransactions(): Response<List<Transaction>>

    @GET("transactions")
    fun getTransactionsRx(): Single<List<Transaction>>

    @GET("transactions")
    fun getTransactionsCall(): Call<List<Transaction>>
}
