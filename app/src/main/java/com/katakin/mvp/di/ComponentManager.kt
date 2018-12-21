package com.katakin.mvp.di

import com.katakin.mvp.App
import com.katakin.mvp.di.base.TreeComponent

object ComponentManager {
    private lateinit var treeComponent: TreeComponent
    private lateinit var appComponent: AppComponent

    fun initAppComponent(app: App) {
        appComponent = DaggerAppComponent.builder()
                .application(app)
                .build()
        treeComponent = TreeComponent(appComponent)
    }

    fun getTreeComponent(): TreeComponent = treeComponent
}