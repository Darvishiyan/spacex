package com.darvishiyan.spacex.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.transition.TransitionInflater
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.android.inject

abstract class BaseFragment<VM : BaseViewModel<DB, BaseModel>, DB : ViewDataBinding> : Fragment() {

    //<editor-fold desc="Variable">
    open val transitionAnimationResId = android.R.transition.move
    abstract val layoutResId: Int
    abstract val viewModelId: Int
    abstract val viewModel: VM
    lateinit var binding: DB
        private set
    lateinit var navigator: NavController
    internal val compositeDisposable: CompositeDisposable by inject()
    //</editor-fold>

    //<editor-fold desc="View Handler">
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(transitionAnimationResId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return onBindView(inflater, container)
    }

    private fun onBindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        binding = bindView(inflater, layoutResId, container, viewModel)
        viewModel.onBindView(binding)
        return binding.root
    }

    private fun bindView(
        inflater: LayoutInflater,
        layoutResId: Int,
        container: ViewGroup?,
        viewModel: VM
    ): DB {
        return DataBindingUtil.inflate<DB>(
            inflater,
            layoutResId,
            container,
            false
        ).apply {
            setVariable(viewModelId, viewModel)
            lifecycleOwner = viewLifecycleOwner
            onLifecycleOwnerBounded(viewLifecycleOwner)
            executePendingBindings()
        }
    }

    open fun onLifecycleOwnerBounded(viewLifecycleOwner: LifecycleOwner) {
        viewModel.onLifecycleOwnerBounded(viewLifecycleOwner)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewBounded(view, savedInstanceState)
        onActive()
    }

    open fun onActive() {}

    open fun onViewBounded(view: View, savedInstanceState: Bundle?) {
        navigator = Navigation.findNavController(view)
        lifecycle.addObserver(viewModel)
        viewModel.onViewBounded(view, savedInstanceState)
    }
    //</editor-fold>

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}