package com.katakin.mvp.di.first

import com.katakin.mvp.di.base.scope.ActivityScope
import com.katakin.mvp.di.base.BaseComponent
import com.katakin.mvp.ui.first.FirstActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [FirstActivityModule::class])
interface FirstActivityComponent : BaseComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): FirstActivityComponent
    }

    fun inject(activity: FirstActivity)
}