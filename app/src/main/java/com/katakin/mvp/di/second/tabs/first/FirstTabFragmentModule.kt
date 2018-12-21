package com.katakin.mvp.di.second.tabs.first

import com.katakin.mvp.di.base.scope.FragmentScope
import com.katakin.mvp.ui.second.tabs.first.FirstTabContract
import com.katakin.mvp.ui.second.tabs.first.FirstTabPresenter
import dagger.Module
import dagger.Provides

@Module
class FirstTabFragmentModule {
    @FragmentScope
    @Provides
    fun providePresenter(presenter: FirstTabPresenter): FirstTabContract.Presenter = presenter
}