package com.darvishiyan.spacex.units.launches

import androidx.databinding.ViewDataBinding
import com.darvishiyan.spacex.core.BaseModel
import com.darvishiyan.spacex.core.BaseViewModel
import com.darvishiyan.spacex.dataaccess.models.Launch
import com.darvishiyan.spacex.utils.EventHandler
import io.reactivex.subjects.PublishSubject
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class LaunchViewModel(
    override val model: LaunchModel,
    private val eventHandler: EventHandler
) : BaseViewModel<ViewDataBinding, BaseModel>() {

    val itemAdapter: LaunchAdapter by inject { parametersOf(openItem) }

    private val openLaunchItem: PublishSubject<Launch> = PublishSubject.create()

    private val openItem = fun(item: Launch) {
        openLaunchItem.onNext(item)
    }

    init {
        model.getLaunches(
            { eventHandler.showLoading() },
            { data ->
                itemAdapter.items = data.sortedByDescending { it.staticFireDateUnix }
            },
            { /*show error*/ },
            { eventHandler.stopLoading() }
        )
    }

    fun onLaunchItemClick() = openLaunchItem

}