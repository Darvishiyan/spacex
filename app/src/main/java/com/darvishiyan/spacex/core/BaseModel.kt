package com.darvishiyan.spacex.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

open class BaseModel(private val compositeDisposable: CompositeDisposable) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun disposeComposite() {
        compositeDisposable.dispose()
    }
}