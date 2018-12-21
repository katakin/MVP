package com.katakin.mvp.di.second.tabs.second

import com.katakin.mvp.di.base.scope.FragmentScope
import com.katakin.mvp.ui.second.tabs.second.SecondTabContract
import com.katakin.mvp.ui.second.tabs.second.SecondTabPresenter
import dagger.Module
import dagger.Provides

@Module
class SecondTabFragmentModule {
    @FragmentScope
    @Provides
    fun providePresenter(presenter: SecondTabPresenter): SecondTabContract.Presenter = presenter
}