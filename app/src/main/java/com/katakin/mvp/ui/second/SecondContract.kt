package com.katakin.mvp.ui.second

import android.os.Bundle

interface SecondContract {

    interface View {
        fun initActionBar()

        fun initViewPager()

        fun initBottomNavigation()

        fun close()
    }

    interface Presenter {
        fun onActivityCreate(view: View, savedInstanceState: Bundle?)

        fun onActivityDestroy()

        fun onBackPressed()
    }
}