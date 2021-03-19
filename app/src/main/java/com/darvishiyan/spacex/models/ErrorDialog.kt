package com.darvishiyan.spacex.models

data class ErrorDialog(
    val title: Int,
    val message: Int,
    val action: Int,
    val run: () -> Unit
)
