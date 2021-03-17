package com.darvishiyan.spacex.units.launches

import com.darvishiyan.spacex.BR
import com.darvishiyan.spacex.R
import com.darvishiyan.spacex.core.BaseItemViewModel
import com.darvishiyan.spacex.core.BaseRecyclerViewAdapter
import com.darvishiyan.spacex.dataaccess.models.Launch
import com.darvishiyan.spacex.units.launches.item.LaunchItemItemViewModel
import org.koin.core.KoinComponent

class LaunchAdapter(
    private val open: (item: Launch) -> Unit
) : BaseRecyclerViewAdapter<Launch>(), KoinComponent {

    override val itemLayoutResId = R.layout.fragment_launch_item
    override val viewModelId = BR.vm

    override fun getViewModel(position: Int, item: Launch): BaseItemViewModel<*> {
        return LaunchItemItemViewModel(item, open)
    }
}