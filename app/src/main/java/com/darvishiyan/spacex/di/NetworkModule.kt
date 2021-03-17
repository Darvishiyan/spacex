package com.darvishiyan.spacex.di

import com.darvishiyan.spacex.dataaccess.remote.ApiService
import com.darvishiyan.spacex.dataaccess.remote.LaunchDataSource
import com.darvishiyan.spacex.dataaccess.repository.LaunchRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

    single { LaunchDataSource(get()) }
    single { LaunchRepository(get()) }

}