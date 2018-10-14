package com.katakin.mvp.di.second.tabs.third

import com.katakin.mvp.di.base.BaseComponent
import com.katakin.mvp.di.base.scope.FragmentScope
import com.katakin.mvp.ui.second.tabs.third.ThirdTabFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ThirdTabFragmentModule::class])
interface ThirdTabComponent : BaseComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ThirdTabComponent
    }

    fun inject(fragment: ThirdTabFragment)
}