package com.android.playground.view.presenters

import androidx.annotation.MainThread
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.lang.ref.WeakReference

abstract class BasePresenter<ViewController> : LifecycleObserver {
    private var viewController = WeakReference<ViewController>(null)
    private var viewLifecycle = WeakReference<Lifecycle>(null)

    @MainThread
    open fun attachView(viewController: ViewController, viewLifecycle: Lifecycle) {
        this.viewController = WeakReference(viewController)
        this.viewLifecycle = WeakReference(
            viewLifecycle.apply {
                addObserver(this@BasePresenter)
            }
        )
    }

    protected open fun onClear() {}

    protected fun viewController(): ViewController? = viewController.get()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onViewDestroyed() {
        viewController.clear()
        viewLifecycle.clear()
        onClear()
    }
}
