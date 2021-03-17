package com.darvishiyan.spacex.di

import org.koin.core.qualifier.named

object Qualifiers {

    val loggerInterceptor = named("LoggerInterceptor")

}