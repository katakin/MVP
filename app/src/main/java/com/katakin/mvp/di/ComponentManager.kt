package com.katakin.mvp.di

import com.katakin.mvp.App
import com.katakin.mvp.di.base.TreeComponent

object ComponentManager {
    private lateinit var components: TreeComponent
    private lateinit var appComponent: AppComponent

    fun initAppComponent(app: App) {
        appComponent = DaggerAppComponent.builder()
                .application(app)
                .build()
        components = TreeComponent(appComponent)
    }

    fun getComponents(): TreeComponent = components
}