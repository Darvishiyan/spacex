package com.darvishiyan.spacex.di

import com.darvishiyan.spacex.utils.EventHandler
import org.koin.dsl.module

val appModule = module {

    single { EventHandler() }

}