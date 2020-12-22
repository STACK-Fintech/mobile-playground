package com.android.playground.api

sealed class ApiResult<out T> {
    data class Success<T>(val body: T) : ApiResult<T>()
    data class Failure(val error: Throwable) : ApiResult<Nothing>()
}
