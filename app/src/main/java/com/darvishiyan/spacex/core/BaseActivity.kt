package com.darvishiyan.spacex.core

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner

abstract class BaseActivity<VM : BaseViewModel<DB, BaseModel>, DB : ViewDataBinding> :
    AppCompatActivity() {

    abstract val layoutResId: Int
    abstract val viewModelId: Int
    abstract val viewModel: VM
    lateinit var binding: DB
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindView(viewModel)
        onViewBounded(binding.root, savedInstanceState)
    }

    /**
     * bind ViewModel to View
     * inform ViewModel from lifecycle
     */
    private fun bindView(viewModel: VM): DB {
        return DataBindingUtil.setContentView<DB>(this, layoutResId).apply {
            setVariable(viewModelId, viewModel)
            lifecycleOwner = this@BaseActivity
            onLifecycleOwnerBounded(this@BaseActivity)
            executePendingBindings()
        }.apply { viewModel.onBindView(this) }
    }

    /**
     * access to lifecycle owner
     */
    open fun onLifecycleOwnerBounded(viewLifecycleOwner: LifecycleOwner) {
        viewModel.onLifecycleOwnerBounded(viewLifecycleOwner)
    }

    /**
     * access to View in ViewModel
     */
    private fun onViewBounded(view: View, savedInstanceState: Bundle?) {
        lifecycle.addObserver(viewModel)
        viewModel.onViewBounded(view, savedInstanceState)
    }
}