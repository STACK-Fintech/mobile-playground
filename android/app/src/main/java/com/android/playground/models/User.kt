package com.android.playground.models

/**
 * @param transactions a list of transactions id.
 */
data class User(
    val firstName: String,
    val lastName: String,
    val transactions: List<String>
)
