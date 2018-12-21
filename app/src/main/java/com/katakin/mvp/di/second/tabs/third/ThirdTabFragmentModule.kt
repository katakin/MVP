package com.katakin.mvp.di.second.tabs.third

import com.katakin.mvp.di.base.scope.FragmentScope
import com.katakin.mvp.ui.second.tabs.third.ThirdTabContract
import com.katakin.mvp.ui.second.tabs.third.ThirdTabPresenter
import dagger.Module
import dagger.Provides

@Module
class ThirdTabFragmentModule {
    @FragmentScope
    @Provides
    fun providePresenter(presenter: ThirdTabPresenter): ThirdTabContract.Presenter = presenter
}