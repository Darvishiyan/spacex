package com.darvishiyan.spacex.core

import android.app.Application
import com.darvishiyan.spacex.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        runKoin()
    }

    private fun runKoin() {
        startKoin {
            androidContext(this@App)
            logger(AndroidLogger(Level.DEBUG))
            modules(
                listOf(
                    appModule,
                    oOkHttpClientModule,
                    retrofitModule,
                    rxModule,
                    networkModule,
                    mainActivityModule,
                    launchFragmentModule,
                    detailFragmentModule,
                )
            )
        }
    }

}