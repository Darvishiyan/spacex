package com.darvishiyan.spacex.di.modules

import com.darvishiyan.spacex.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

@Module
class OkHttpClientModule {

    @Provides
    fun httpLoggingInterceptor() =
        HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.i(message)
            }
        }).apply { setLevel(HttpLoggingInterceptor.Level.BODY) }

    @Provides
    @ApplicationScope
    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

}