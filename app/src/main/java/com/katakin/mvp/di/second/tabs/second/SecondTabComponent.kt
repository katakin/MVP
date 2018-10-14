package com.katakin.mvp.di.second.tabs.second

import com.katakin.mvp.di.base.BaseComponent
import com.katakin.mvp.di.base.scope.FragmentScope
import com.katakin.mvp.ui.second.tabs.second.SecondTabFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [SecondTabFragmentModule::class])
interface SecondTabComponent : BaseComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): SecondTabComponent
    }

    fun inject(fragment: SecondTabFragment)
}