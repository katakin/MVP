package com.katakin.mvp.ui.splash

import com.katakin.mvp.base.ui.mvp.MvpBasePresenter
import com.katakin.mvp.data.IPreferenceHelper
import com.katakin.mvp.di.splash.SplashScore
import javax.inject.Inject
import javax.inject.Named

@SplashScore
class SplashPresenter @Inject constructor(
        @Named("User") private val userPreferenceHelper: IPreferenceHelper
) : MvpBasePresenter<SplashContract.View>(), SplashContract.Presenter {

}