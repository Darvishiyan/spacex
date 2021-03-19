package com.darvishiyan.spacex.units.detail

import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.navArgs
import com.darvishiyan.spacex.BR
import com.darvishiyan.spacex.R
import com.darvishiyan.spacex.core.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : BaseFragment<DetailViewModel, ViewDataBinding>() {

    private val args: DetailFragmentArgs by navArgs()
    override val layoutResId = R.layout.fragment_detail
    override val viewModelId = BR.vm
    override val viewModel: DetailViewModel by viewModel { parametersOf(args.launch) }

}