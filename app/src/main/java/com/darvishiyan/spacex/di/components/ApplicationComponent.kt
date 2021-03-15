package com.darvishiyan.spacex.di.components

import com.darvishiyan.spacex.dataaccess.remote.ApiService
import com.darvishiyan.spacex.di.modules.LaunchesModule
import com.darvishiyan.spacex.di.scopes.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [LaunchesModule::class])
interface ApplicationComponent {

    fun getApiService(): ApiService

}