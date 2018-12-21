package com.katakin.mvp.di

import com.katakin.core.di.AppDependencies
import com.katakin.mvp.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AppDependencies {

    fun inject(app: App)

    class Initializer private constructor() {
        companion object {
            fun init(): AppComponent = DaggerAppComponent
                .builder()
                .build()
        }
    }
}