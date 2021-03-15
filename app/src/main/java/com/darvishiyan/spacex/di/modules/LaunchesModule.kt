package com.darvishiyan.spacex.di.modules

import com.darvishiyan.spacex.dataaccess.remote.ApiService
import com.darvishiyan.spacex.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [RetrofitModule::class])
class LaunchesModule {

    @Provides
    @ApplicationScope
    fun apiService(retrofit: Retrofit) =
        retrofit.create(ApiService::class.java)
}