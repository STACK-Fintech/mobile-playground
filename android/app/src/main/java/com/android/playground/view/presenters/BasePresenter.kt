package com.android.playground.view.presenters

import androidx.annotation.MainThread
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

abstract class BasePresenter<ViewController> : LifecycleObserver {
    private var viewController: ViewController? = null
    private var viewLifecycle: Lifecycle? = null

    @MainThread
    open fun attachView(viewController: ViewController, viewLifecycle: Lifecycle) {
        this.viewController = viewController
        this.viewLifecycle = viewLifecycle.apply {
            addObserver(this@BasePresenter)
        }
    }

    protected open fun onClear() {}

    protected fun viewController(): ViewController? = viewController

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onViewDestroyed() {
        viewController = null
        viewLifecycle = null
        onClear()
    }
}
