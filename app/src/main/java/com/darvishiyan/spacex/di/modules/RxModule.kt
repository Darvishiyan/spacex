package com.darvishiyan.spacex.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class RxModule {

    @Provides
    fun compositeDisposable() = CompositeDisposable()
}