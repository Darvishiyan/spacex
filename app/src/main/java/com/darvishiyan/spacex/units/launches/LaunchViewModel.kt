package com.darvishiyan.spacex.units.launches

import androidx.databinding.ViewDataBinding
import com.darvishiyan.spacex.core.BaseModel
import com.darvishiyan.spacex.core.BaseViewModel
import com.darvishiyan.spacex.dataaccess.models.Launch
import io.reactivex.subjects.PublishSubject
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class LaunchViewModel(
    override val model: LaunchModel
) : BaseViewModel<ViewDataBinding, BaseModel>() {

    private val openLaunchItem: PublishSubject<Launch> = PublishSubject.create()

    private val openItem = fun(item: Launch) {
        openLaunchItem.onNext(item)
    }

    val itemAdapter: LaunchAdapter by inject { parametersOf(openItem) }

    init {
        model.getLaunches(
            {
                //show loading
            }, {
                itemAdapter.items = it
            }, {
                //show error
            }, {
                //stop loading
            }
        )
    }

    fun onLaunchItemClick() = openLaunchItem

}