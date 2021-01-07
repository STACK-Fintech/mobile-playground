package com.android.playground.models

import java.util.Date

data class Transaction(
    val transactionId: String,
    val transactionDescription: String,
    val transactionType: String,
    val transactionDate: Date,
    val transactionAmount: Double
)
