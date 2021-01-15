package com.android.playground.util

import java.text.NumberFormat
import java.util.*

fun Double.formatToCurrencyStr(
    minFractionDigit: Int = 2,
    maxFractionDigit: Int = 2
): String {
    val numberFormat = NumberFormat.getCurrencyInstance(Locale.CANADA).apply {
        minimumFractionDigits = minFractionDigit
        maximumFractionDigits = maxFractionDigit
    }
    return numberFormat.format(this)
}
