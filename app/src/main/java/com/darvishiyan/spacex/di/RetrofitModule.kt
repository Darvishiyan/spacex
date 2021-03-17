package com.darvishiyan.spacex.di

import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    factory { GsonBuilder().create() }

    factory<Converter.Factory> { GsonConverterFactory.create(get()) }

    factory<CallAdapter.Factory> { RxJava2CallAdapterFactory.create() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/")
            .client(get())
            .addConverterFactory(get())
            .addCallAdapterFactory(get())
            .build()
    }

}