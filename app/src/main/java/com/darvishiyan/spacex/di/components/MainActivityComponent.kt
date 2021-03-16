package com.darvishiyan.spacex.di.components

import com.darvishiyan.spacex.di.modules.MainActivityModule
import com.darvishiyan.spacex.di.scopes.MainActivityScope
import com.darvishiyan.spacex.units.main.MainModel
import com.darvishiyan.spacex.units.main.MainViewModel
import dagger.Component

@MainActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    fun viewModel(): MainViewModel
    fun model(): MainModel

}