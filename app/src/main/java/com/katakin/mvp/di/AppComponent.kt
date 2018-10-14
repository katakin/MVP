package com.katakin.mvp.di

import com.katakin.mvp.App
import com.katakin.mvp.di.base.BaseComponent
import com.katakin.mvp.di.first.FirstActivityComponent
import com.katakin.mvp.di.second.SecondActivityComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent : BaseComponent {

    fun firstBuilder(): FirstActivityComponent.Builder

    fun secondBuilder(): SecondActivityComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }
}