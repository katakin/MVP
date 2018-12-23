package com.katakin.mvp

import android.app.Application
import com.katakin.mvp.di.AppComponent
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.support.CompatInjectionManager

class App : Application(), IHasComponent<AppComponent> {

    override fun onCreate() {
        super.onCreate()
        CompatInjectionManager.init(this)
        CompatInjectionManager.instance
                .bindComponent(this)
                .inject(this)
    }

    override fun getComponent(): AppComponent {
        return AppComponent.Initializer.init(this)
    }
}