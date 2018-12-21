package com.katakin.mvp.di.first

import com.katakin.mvp.di.base.scope.ActivityScope
import com.katakin.mvp.ui.first.FirstContract
import com.katakin.mvp.ui.first.FirstPresenter
import dagger.Module
import dagger.Provides

@Module
class FirstActivityModule {
    @ActivityScope
    @Provides
    fun providePresenter(presenter: FirstPresenter): FirstContract.Presenter = presenter
}