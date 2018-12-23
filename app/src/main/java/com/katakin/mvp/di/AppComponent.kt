package com.katakin.mvp.di

import android.content.Context
import com.katakin.mvp.App
import dagger.BindsInstance
import dagger.Component
import dagger.internal.DaggerCollections
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AppDependencies {

    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(applicationContext: Context): Builder

        fun build(): AppComponent
    }

    class Initializer private constructor() {
        companion object {
            fun init(applicationContext: Context): AppComponent = DaggerAppComponent.builder()
                    .context(applicationContext)
                    .build()
        }
    }
}