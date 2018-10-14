package com.katakin.mvp.di.second

import com.katakin.mvp.di.base.scope.ActivityScope
import com.katakin.mvp.di.base.BaseComponent
import com.katakin.mvp.di.second.tabs.first.FirstTabComponent
import com.katakin.mvp.di.second.tabs.second.SecondTabComponent
import com.katakin.mvp.di.second.tabs.third.ThirdTabComponent
import com.katakin.mvp.ui.second.SecondActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [SecondActivityModule::class])
interface SecondActivityComponent : BaseComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): SecondActivityComponent
    }

    fun firstTabBuilder(): FirstTabComponent.Builder
    fun secondTabBuilder(): SecondTabComponent.Builder
    fun thirdTabBuilder(): ThirdTabComponent.Builder

    fun inject(activity: SecondActivity)
}