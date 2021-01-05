package com.android.playground.view.presenters

import androidx.lifecycle.Lifecycle

class AdminPanelPresenter : BasePresenter<AdminPanelViewController>() {

    override fun attachView(
        viewController: AdminPanelViewController,
        viewLifecycle: Lifecycle
    ) {
        super.attachView(viewController, viewLifecycle)
    }

    override fun onClear() {}
}
