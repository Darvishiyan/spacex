package com.darvishiyan.spacex.units.launches

import androidx.databinding.ViewDataBinding
import com.darvishiyan.spacex.BR
import com.darvishiyan.spacex.R
import com.darvishiyan.spacex.core.BaseFragment
import io.reactivex.rxkotlin.addTo
import org.koin.android.viewmodel.ext.android.viewModel

class LaunchFragment : BaseFragment<LaunchViewModel, ViewDataBinding>() {

    override val layoutResId = R.layout.fragment_launch
    override val viewModelId = BR.vm
    override val viewModel: LaunchViewModel by viewModel()

    override fun onActive() {
        viewModel.onLaunchItemClick().subscribe {
            //go to next page
        }.addTo(compositeDisposable)
    }

}