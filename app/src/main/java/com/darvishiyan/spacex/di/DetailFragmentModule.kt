package com.darvishiyan.spacex.di

import com.darvishiyan.spacex.dataaccess.models.Launch
import com.darvishiyan.spacex.units.detail.DetailModel
import com.darvishiyan.spacex.units.detail.DetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailFragmentModule = module {

    factory { DetailModel(get(), get()) }

    viewModel { (launch: Launch) -> DetailViewModel(get(), launch, get()) }

}