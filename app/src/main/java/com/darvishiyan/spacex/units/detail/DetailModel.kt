package com.darvishiyan.spacex.units.detail

import com.darvishiyan.spacex.core.BaseModel
import com.darvishiyan.spacex.dataaccess.models.Launch
import com.darvishiyan.spacex.dataaccess.repository.LaunchRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

class DetailModel(
    private val repository: LaunchRepository,
    private val compositeDisposable: CompositeDisposable,
) : BaseModel(compositeDisposable) {

    fun getLaunches(
        id: String,
        start: (Disposable) -> Unit,
        success: (Launch) -> Unit,
        failed: (Throwable) -> Unit,
        end: () -> Unit,
    ) {
        repository.getLaunch(id)
            .doOnSubscribe(start)
            .doOnSuccess(success)
            .doOnError(failed)
            .doFinally(end)
            .subscribe({}, {})
            .addTo(compositeDisposable)
    }
}