package com.darvishiyan.spacex.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.darvishiyan.spacex.models.ErrorDialog

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

    private val _setActionBarTitle = MutableLiveData<Event<String>>()

    val setActionBarTitleObserver: LiveData<Event<String>>
        get() = _setActionBarTitle

    fun setActionBarTitle(result: String) {
        _setActionBarTitle.value = Event(result)
    }

    private val _resetActionBarTitle = SingleLiveEvent<Any>()

    val resetActionBarTitleObserver: LiveData<Any>
        get() = _resetActionBarTitle as LiveData<Any>

    fun resetActionBarTitle() {
        _resetActionBarTitle.call()
    }

    private val _showErrorDialog = MutableLiveData<Event<ErrorDialog>>()

    val showErrorDialogObserver: LiveData<Event<ErrorDialog>>
        get() = _showErrorDialog

    fun showErrorDialog(data: ErrorDialog) {
        _showErrorDialog.value = Event(data)
    }

}