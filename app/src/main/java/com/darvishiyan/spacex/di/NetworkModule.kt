package com.darvishiyan.spacex.di.modules

import com.darvishiyan.spacex.dataaccess.remote.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

}