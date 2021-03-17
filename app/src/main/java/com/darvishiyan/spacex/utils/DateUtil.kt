package com.darvishiyan.spacex.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.getVisualizeDate(): String {
    val simpleDateFormat = SimpleDateFormat(
        "EEEE, MMM dd, yyyy - HH:mm",
        Locale.getDefault()
    )
    return simpleDateFormat.format(this)
}