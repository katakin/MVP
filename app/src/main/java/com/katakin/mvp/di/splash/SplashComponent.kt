package com.katakin.mvp.di.splash

import com.katakin.core.di.AppDependencies
import com.katakin.mvp.di.AppComponent
import com.katakin.mvp.ui.splash.SplashActivity
import dagger.Component
import me.vponomarenko.injectionmanager.support.CompatInjectionManager

@SplashScore
@Component(
        dependencies = [AppDependencies::class],
        modules = [SplashModule::class]
)
interface SplashComponent {
    fun inject(activity: SplashActivity)

    class Initializer private constructor() {
        companion object {
            fun init(): SplashComponent = DaggerSplashComponent.builder()
                    .appDependencies(CompatInjectionManager.instance.findComponent<AppComponent>())
                    .build()
        }
    }
}