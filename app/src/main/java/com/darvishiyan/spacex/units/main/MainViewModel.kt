package com.darvishiyan.spacex.units.main

import androidx.databinding.Bindable
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.darvishiyan.spacex.BR
import com.darvishiyan.spacex.core.BaseModel
import com.darvishiyan.spacex.core.BaseViewModel
import com.darvishiyan.spacex.utils.EventHandler

class MainViewModel(
    override val model: MainModel,
    val eventHandler: EventHandler
) : BaseViewModel<ViewDataBinding, BaseModel>() {

    @Bindable
    var loading = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }

    override fun onLifecycleOwnerBounded(viewLifecycleOwner: LifecycleOwner) {
        super.onLifecycleOwnerBounded(viewLifecycleOwner)
        eventHandler.showLoadingObserver.observe(viewLifecycleOwner) {
            loading = true
        }
        eventHandler.stopLoadingObserver.observe(viewLifecycleOwner) {
            loading = false
        }
    }

}