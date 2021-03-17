package com.darvishiyan.spacex.dataaccess.remote

class LaunchDataSource(private val api: ApiService) {

    fun getLaunches() = api.getLaunches()

    fun getLaunch(id: String) = api.getLaunch(id)

}