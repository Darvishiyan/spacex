package com.darvishiyan.spacex.units.launches.item

import androidx.databinding.ViewDataBinding
import com.darvishiyan.spacex.core.BaseItemViewModel
import com.darvishiyan.spacex.dataaccess.models.Launch

class LaunchItemItemViewModel(
    val launch: Launch,
    private val open: (item: Launch) -> Unit
) : BaseItemViewModel<ViewDataBinding>() {

    fun openLaunch() = open(launch)

}