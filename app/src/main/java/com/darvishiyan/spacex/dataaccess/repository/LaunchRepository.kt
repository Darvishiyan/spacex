package com.darvishiyan.spacex.dataaccess.repository

import com.darvishiyan.spacex.dataaccess.remote.LaunchDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LaunchRepository(private val remove: LaunchDataSource) {

    fun getLaunches() = remove.getLaunches()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    fun getLaunch(id: String) = remove.getLaunch(id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}