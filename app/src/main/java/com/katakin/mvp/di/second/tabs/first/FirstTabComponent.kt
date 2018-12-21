package com.katakin.mvp.di.second.tabs.first

import com.katakin.mvp.di.base.BaseComponent
import com.katakin.mvp.di.base.scope.FragmentScope
import com.katakin.mvp.ui.second.tabs.first.FirstTabFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [FirstTabFragmentModule::class])
interface FirstTabComponent : BaseComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): FirstTabComponent
    }

    fun inject(fragment: FirstTabFragment)
}