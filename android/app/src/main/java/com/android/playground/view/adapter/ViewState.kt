package com.android.playground.view.adapter

enum class Status {
    LOADING,
    SUCCESS,
    FAILURE
}

data class ViewState(
    val state: Status,
    val items: List<ViewStateItem>? = null
)

sealed class ViewStateItem {
    data class HeaderItem(
        val title: String
    ) : ViewStateItem()

    data class TransactionItem(
        val description: String,
        val amount: String,
        val date: String
    ) : ViewStateItem()
}
