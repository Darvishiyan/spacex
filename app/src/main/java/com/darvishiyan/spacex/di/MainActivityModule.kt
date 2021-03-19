package com.darvishiyan.spacex.di

import com.darvishiyan.spacex.models.ErrorDialogModel
import com.darvishiyan.spacex.units.main.ErrorDialogFragment
import com.darvishiyan.spacex.units.main.MainModel
import com.darvishiyan.spacex.units.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainActivityModule = module {

    factory { MainModel(get()) }

    viewModel { MainViewModel(get(), get()) }

    factory { (data: ErrorDialogModel) -> ErrorDialogFragment().apply { dataModel = data } }

}