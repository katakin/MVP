package com.katakin.mvp.di.splash

import com.katakin.mvp.ui.splash.SplashContract
import com.katakin.mvp.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @SplashScore
    @Provides
    fun providePresenter(presenter: SplashPresenter): SplashContract.Presenter = presenter
}