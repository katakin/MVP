package com.katakin.mvp.ui.splash

import android.os.Bundle
import com.katakin.mvp.R
import com.katakin.mvp.base.ui.mvp.MvpActivity
import com.katakin.mvp.di.splash.SplashComponent
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.support.CompatInjectionManager

class SplashActivity : MvpActivity<SplashContract.View, SplashContract.Presenter>(), SplashContract.View, IHasComponent<SplashComponent> {

    override fun injectComponent() {
        CompatInjectionManager.bindComponent(this).inject(this)
    }

    override fun getComponent(): SplashComponent {
        return SplashComponent.Initializer.init()
    }

    override fun onCreateView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_splash)
    }

    override fun getView(): SplashContract.View = this
}