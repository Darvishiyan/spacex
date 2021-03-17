package com.darvishiyan.spacex.utils

import android.widget.ImageView
import com.darvishiyan.spacex.R
import com.squareup.picasso.Picasso

fun loadImage(url: String, imageView: ImageView, placeholder: Int = R.color.transparent) {
    Picasso.get()
        .load(url)
        .placeholder(placeholder)
        .into(imageView)
}