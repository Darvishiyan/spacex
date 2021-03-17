package com.darvishiyan.spacex.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.darvishiyan.spacex.R

@BindingAdapter(value = ["loadAdapter"])
fun RecyclerView.loadAdapter(itemAdapter: RecyclerView.Adapter<*>?) {
    itemAdapter?.let {
        adapter = it
    }
}

@BindingAdapter(value = ["loadUrl"])
fun ImageView.loadUrl(url: String?) {
    url?.takeIf { it.isNotEmpty() }?.let {
        loadImage(it, this, R.drawable.x_logo)
    }
}