package com.darvishiyan.spacex.di.modules

import com.darvishiyan.spacex.di.scopes.MainActivityScope
import com.darvishiyan.spacex.units.main.MainModel
import com.darvishiyan.spacex.units.main.MainViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module(includes = [RxModule::class])
class MainActivityModule {

    @Provides
    @MainActivityScope
    fun mainViewModel(model: MainModel) = MainViewModel(model)

    @Provides
    @MainActivityScope
    fun mainModel(compositeDisposable: CompositeDisposable) = MainModel(compositeDisposable)

}