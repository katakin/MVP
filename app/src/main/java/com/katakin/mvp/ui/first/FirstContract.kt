package com.katakin.mvp.ui.first

import android.os.Bundle

interface FirstContract {

    interface View {
        fun initActionBar()

        fun initViewText()

        fun initPresenterText(hashCode: Int)

        fun initComponents()

        fun showSecondActivity()
    }

    interface Presenter {
        fun onActivityCreate(view: View, savedInstanceState: Bundle?)

        fun onActivityDestroy()

        fun onNextBtnPressed()
    }
}