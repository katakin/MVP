package com.katakin.mvp.ui.splash

import com.katakin.mvp.di.splash.SplashScore
import com.katakin.mvp.ui.base.mvp.MvpBasePresenter
import javax.inject.Inject

@SplashScore
class SplashPresenter @Inject constructor(

) : MvpBasePresenter<SplashContract.View>(), SplashContract.Presenter {

}