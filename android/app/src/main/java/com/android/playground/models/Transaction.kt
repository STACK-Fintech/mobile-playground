package com.android.playground.models

import java.util.*

data class Transaction(
    val transactionId: String,
    val transactionType: String,
    val transactionDate: Date,
    val transactionAmount: Double
)
