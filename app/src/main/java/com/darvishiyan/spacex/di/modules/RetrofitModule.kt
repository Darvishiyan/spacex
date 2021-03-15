package com.darvishiyan.spacex.di.modules

import com.darvishiyan.spacex.di.scopes.ApplicationScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = [OkHttpClientModule::class])
class RetrofitModule {

    @Provides
    fun gson() = GsonBuilder().create()

    @Provides
    fun gsonConverterFactory(gson: Gson) = GsonConverterFactory.create(gson)

    @Provides
    @ApplicationScope
    fun retrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory) =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.spacexdata.com/")
            .addConverterFactory(gsonConverterFactory)
            .build()

}