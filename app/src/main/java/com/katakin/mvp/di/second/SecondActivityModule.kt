package com.katakin.mvp.di.second

import com.katakin.mvp.di.base.scope.ActivityScope
import com.katakin.mvp.di.second.tabs.first.FirstTabComponent
import com.katakin.mvp.di.second.tabs.second.SecondTabComponent
import com.katakin.mvp.di.second.tabs.third.ThirdTabComponent
import com.katakin.mvp.ui.second.SecondContract
import com.katakin.mvp.ui.second.SecondPresenter
import dagger.Module
import dagger.Provides

@Module(subcomponents = [FirstTabComponent::class, SecondTabComponent::class, ThirdTabComponent::class])
class SecondActivityModule {
    @ActivityScope
    @Provides
    fun providePresenter(presenter: SecondPresenter): SecondContract.Presenter = presenter
}