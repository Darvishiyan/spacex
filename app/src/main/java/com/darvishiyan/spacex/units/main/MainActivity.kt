package com.darvishiyan.spacex.units.main

import androidx.databinding.ViewDataBinding
import com.darvishiyan.spacex.BR
import com.darvishiyan.spacex.R
import com.darvishiyan.spacex.core.App
import com.darvishiyan.spacex.core.BaseActivity
import com.darvishiyan.spacex.di.components.DaggerMainActivityComponent
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel, ViewDataBinding>() {

    override val layoutResId = R.layout.activity_main
    override val viewModelId = BR.vm

    @Inject
    override lateinit var viewModel: MainViewModel

    override fun daggerComponentBuilder() {
        DaggerMainActivityComponent.builder()
            .applicationComponent(App.getApplication(this).getApplicationComponent())
            .build()
    }

}