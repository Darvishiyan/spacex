package com.darvishiyan.spacex.core

import android.os.Bundle
import android.view.View
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

abstract class BaseItemViewModel<DB : ViewDataBinding> :
    ViewModel(),
    Observable,
    KoinComponent,
    LifecycleObserver {

    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()
    lateinit var binding: DB
        private set

    //<editor-fold desc="Observable">
    override fun addOnPropertyChangedCallback(
        callback: Observable.OnPropertyChangedCallback
    ) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(
        callback: Observable.OnPropertyChangedCallback
    ) {
        callbacks.remove(callback)
    }

    fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }

    fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }
    //</editor-fold>

    /**
     * call this method after bind layout to [DB] in onCreateView
     */
    open fun onBindView(binding: DB) {
        this.binding = binding
    }

    /**
     * call this method in onViewCreated
     */
    open fun onViewBounded(view: View, savedInstanceState: Bundle?) {}

}