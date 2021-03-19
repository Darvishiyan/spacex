package com.darvishiyan.spacex.units.detail

import android.os.Bundle
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.ViewDataBinding
import com.darvishiyan.spacex.BR
import com.darvishiyan.spacex.core.BaseModel
import com.darvishiyan.spacex.core.BaseViewModel
import com.darvishiyan.spacex.dataaccess.models.Launch
import com.darvishiyan.spacex.utils.EventHandler

class DetailViewModel(
    override val model: DetailModel,
    var launch: Launch,
    private val eventHandler: EventHandler
) : BaseViewModel<ViewDataBinding, BaseModel>() {

    @Bindable
    var loading = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }

    @Bindable
    var offlineData = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.offlineData)
        }

    override fun onViewBounded(view: View, savedInstanceState: Bundle?) {
        super.onViewBounded(view, savedInstanceState)
        launch.name?.let { eventHandler.setActionBarTitle(it) }
    }

    init {
        launch.id?.let {
            model.getLaunches(it,
                { loading = true },
                { data ->
                    launch = data
                    notifyChange()
                },
                { offlineData = true },
                { loading = false }
            )
        }
    }

}