package com.android.playground.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.playground.R
import com.android.playground.view.adapter.ViewStateViewHolder.HeaderViewHolder
import com.android.playground.view.adapter.ViewStateViewHolder.TransactionViewHolder
import java.lang.IllegalStateException

class ViewStateAdapter : RecyclerView.Adapter<ViewStateViewHolder>() {
    private var _items: List<ViewStateItem> = listOf()

    override fun getItemViewType(position: Int): Int =
        when (_items[position]) {
            is ViewStateItem.HeaderItem -> HEADER_VIEW_TYPE
            is ViewStateItem.TransactionItem -> TRANSACTION_VIEW_TYPE
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewStateViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            HEADER_VIEW_TYPE ->
                HeaderViewHolder(layoutInflater.inflate(R.layout.row_header, parent, false))
            TRANSACTION_VIEW_TYPE ->
                TransactionViewHolder(layoutInflater.inflate(R.layout.row_transaction, parent, false))
            else -> throw IllegalStateException("wrong view type")
        }
    }

    override fun onBindViewHolder(holder: ViewStateViewHolder, position: Int) {
        when (val item = _items[position]) {
            is ViewStateItem.HeaderItem -> (holder as HeaderViewHolder).bind(item)
            is ViewStateItem.TransactionItem -> (holder as TransactionViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = _items.size

    fun setDataList(items: List<ViewStateItem>) {
        _items = items
        notifyDataSetChanged()
    }

    companion object {
        private const val HEADER_VIEW_TYPE = 1
        private const val TRANSACTION_VIEW_TYPE = 2
    }
}

sealed class ViewStateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    class HeaderViewHolder(itemView: View) : ViewStateViewHolder(itemView) {
        fun bind(item: ViewStateItem.HeaderItem) {
            // TODO
        }
    }

    class TransactionViewHolder(itemView: View) : ViewStateViewHolder(itemView) {
        fun bind(item: ViewStateItem.TransactionItem) {
            // TODO
        }
    }
}
