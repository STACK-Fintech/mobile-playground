package com.android.playground.api

import com.android.playground.models.Transaction
import com.android.playground.models.User
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @GET("users")
    fun getUsersRx(): Observable<List<User>>

    @GET("users")
    fun getUsersCall(): Call<Response<List<User>>>

    @GET("transactions")
    suspend fun getTransactions(): Response<List<Transaction>>

    @GET("users")
    fun getTransactionsRx(): Observable<List<Transaction>>

    @GET("users")
    fun getTransactionsCall(): Call<Response<List<Transaction>>>
}
