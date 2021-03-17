package com.darvishiyan.spacex.di

import com.darvishiyan.spacex.dataaccess.models.Launch
import com.darvishiyan.spacex.units.launches.LaunchAdapter
import com.darvishiyan.spacex.units.launches.LaunchModel
import com.darvishiyan.spacex.units.launches.LaunchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val launchFragmentModule = module {

    factory { LaunchModel(get(), get()) }

    viewModel { LaunchViewModel(get(), get()) }

    factory { (open: (item: Launch) -> Unit) -> LaunchAdapter(open) }

}