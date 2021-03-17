package com.darvishiyan.spacex.di

import com.darvishiyan.spacex.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val oOkHttpClientModule = module {

    single<Interceptor>(Qualifiers.loggerInterceptor) {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient().newBuilder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .also {
                if (BuildConfig.DEBUG) {
                    it.addInterceptor(get<Interceptor>(Qualifiers.loggerInterceptor))
                }
            }.build()
    }

}