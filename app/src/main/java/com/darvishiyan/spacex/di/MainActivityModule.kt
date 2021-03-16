package com.darvishiyan.spacex.di.modules

import com.darvishiyan.spacex.units.main.MainModel
import com.darvishiyan.spacex.units.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainActivityModule = module {

    factory { MainModel(get()) }

    viewModel { MainViewModel(get()) }

}