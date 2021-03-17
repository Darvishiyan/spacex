package com.darvishiyan.spacex.units.main

import androidx.databinding.ViewDataBinding
import com.darvishiyan.spacex.BR
import com.darvishiyan.spacex.R
import com.darvishiyan.spacex.core.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, ViewDataBinding>() {

    override val layoutResId = R.layout.activity_main
    override val viewModelId = BR.vm
    override val viewModel: MainViewModel by viewModel()

}