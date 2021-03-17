package com.darvishiyan.spacex.utils

import androidx.lifecycle.LiveData

@Suppress("UNCHECKED_CAST")
class EventHandler {

    private val _showLoading = SingleLiveEvent<Any>()

    val showLoadingObserver: LiveData<Any>
        get() = _showLoading as LiveData<Any>

    fun showLoading() {
        _showLoading.call()
    }

    private val _stopLoading = SingleLiveEvent<Any>()

    val stopLoadingObserver: LiveData<Any>
        get() = _stopLoading as LiveData<Any>

    fun stopLoading() {
        _stopLoading.call()
    }

}