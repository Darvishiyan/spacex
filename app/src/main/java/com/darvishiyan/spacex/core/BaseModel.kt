package com.darvishiyan.spacex.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.component.KoinComponent

/**
 * auto composite model
 */
open class BaseModel(
    private val compositeDisposable: CompositeDisposable
) : LifecycleObserver, KoinComponent {

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun disposeComposite() {
        compositeDisposable.dispose()
    }
}