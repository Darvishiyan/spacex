package com.darvishiyan.spacex.dataaccess.remote

import com.darvishiyan.spacex.dataaccess.models.Launch
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v4/launches")
    fun getLaunches(): Single<List<Launch>>

    @GET("v4/launches/{id}")
    fun getLaunch(@Path("id") id: String): Single<Launch>

}