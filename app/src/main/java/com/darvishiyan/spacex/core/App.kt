package com.darvishiyan.spacex.core

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.darvishiyan.spacex.di.components.ApplicationComponent
import com.darvishiyan.spacex.di.components.DaggerApplicationComponent

class App : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    companion object {
        fun getApplication(activity: AppCompatActivity) = activity.application as App
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }

    fun getApplicationComponent() = applicationComponent


}