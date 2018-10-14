package com.katakin.mvp

import android.app.Application
import com.katakin.mvp.di.ComponentManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentManager.initAppComponent(this)
    }
}