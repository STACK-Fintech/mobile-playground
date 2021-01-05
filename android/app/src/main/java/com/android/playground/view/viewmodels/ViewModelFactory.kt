package com.android.playground.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory class that allows [ViewModel] classes to be instantiated with constructor arguments.
 */
class ViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when (modelClass) {
            AdminPanelViewModel::class.java -> AdminPanelViewModel() as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
}
