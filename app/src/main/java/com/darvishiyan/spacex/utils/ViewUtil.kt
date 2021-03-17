package com.darvishiyan.spacex.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter(value = ["loadAdapter"])
fun RecyclerView.loadAdapter(itemAdapter: RecyclerView.Adapter<*>?) {
    itemAdapter?.let {
        adapter = it
    }
}
