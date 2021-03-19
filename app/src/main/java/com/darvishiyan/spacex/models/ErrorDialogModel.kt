package com.darvishiyan.spacex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ErrorDialogModel(
    val title: Int,
    val message: Int,
    val action: Int,
    val run: () -> Unit
) : Parcelable
