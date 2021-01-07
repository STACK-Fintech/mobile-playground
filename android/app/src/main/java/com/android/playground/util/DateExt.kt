package com.android.playground.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

enum class DateFormat(val value: String) {
    MMMM_DD_YYYY("MMMM dd, yyyy"),
    H_MM_A("h:mm a")
}

fun Date.extractDateString(): String {
    val sdf = SimpleDateFormat(DateFormat.MMMM_DD_YYYY.value, Locale.getDefault())
    return sdf.format(this)
}

fun Date.extractTimeString(): String {
    val sdf = SimpleDateFormat(DateFormat.H_MM_A.value, Locale.getDefault())
    return sdf.format(this)
}
