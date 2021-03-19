package com.darvishiyan.spacex.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T> :
    RecyclerView.Adapter<BaseRecyclerViewAdapter<T>.ItemViewHolder>() {

    abstract val itemLayoutResId: Int
    abstract val viewModelId: Int
    var items = listOf<T>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = onBindView(layoutInflater, parent, viewType)
        return ItemViewHolder(binding)
    }

    open fun onBindView(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ViewDataBinding =
        DataBindingUtil.inflate(layoutInflater, itemLayoutResId, parent, false)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(getViewModel(position, items[position]))

    abstract fun getViewModel(position: Int, item: T): BaseItemViewModel<*>

    override fun onViewAttachedToWindow(holder: ItemViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.onAppear()
    }

    override fun onViewDetachedFromWindow(holder: ItemViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.onDisappear()
    }

    inner class ItemViewHolder(
        private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root), LifecycleOwner {

        private val lifecycleRegistry = LifecycleRegistry(this)

        init {
            lifecycleRegistry.currentState = Lifecycle.State.INITIALIZED
        }


        fun onAppear() {
            lifecycleRegistry.currentState = Lifecycle.State.CREATED
            lifecycleRegistry.currentState = Lifecycle.State.STARTED
        }

        fun onDisappear() {
            lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
        }

        override fun getLifecycle() = lifecycleRegistry

        fun bind(itemViewModel: BaseItemViewModel<*>) {
            binding.apply {
                lifecycleOwner = this@ItemViewHolder
                setVariable(viewModelId, itemViewModel)
                executePendingBindings()
            }
        }
    }
}