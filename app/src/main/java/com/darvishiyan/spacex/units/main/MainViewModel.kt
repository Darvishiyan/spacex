package com.darvishiyan.spacex.units.main

import androidx.databinding.Bindable
import androidx.databinding.ViewDataBinding
import com.darvishiyan.spacex.BR
import com.darvishiyan.spacex.core.BaseModel
import com.darvishiyan.spacex.core.BaseViewModel
import com.darvishiyan.spacex.utils.EventHandler

class MainViewModel(
    override val model: MainModel,
    private val eventHandler: EventHandler
) : BaseViewModel<ViewDataBinding, BaseModel>() {

    @Bindable
    var loading = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }

    init {
        eventHandler.showLoadingObserver.observeForever { loading = true }
        eventHandler.stopLoadingObserver.observeForever { loading = false }
    }

}