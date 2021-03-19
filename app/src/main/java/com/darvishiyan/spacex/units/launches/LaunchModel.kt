package com.darvishiyan.spacex.units.launches

import com.darvishiyan.spacex.core.BaseModel
import com.darvishiyan.spacex.dataaccess.models.Launch
import com.darvishiyan.spacex.dataaccess.repository.LaunchRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

class LaunchModel(
    private val repository: LaunchRepository,
    private val compositeDisposable: CompositeDisposable
) : BaseModel(compositeDisposable) {

    fun getLaunches(
        start: (Disposable) -> Unit,
        success: (List<Launch>) -> Unit,
        failed: (Throwable) -> Unit,
        end: () -> Unit,
    ) {
        repository.getLaunches()
            .doOnSubscribe(start)
            .doOnSuccess(success)
            .doOnError(failed)
            .doFinally(end)
            .subscribe({}, {})
            .addTo(compositeDisposable)
    }
}