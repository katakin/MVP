package com.katakin.mvp.ui.second.tabs.first

interface FirstTabContract {
    interface View {
        fun initViewText()

        fun initPresenterText(hashCode: Int)

        fun initComponents()
    }

    interface Presenter {
        fun onFragmentAttach(view: View)

        fun onVisibleToUser()

        fun onInvisibleToUser()

        fun onFragmentDetach()
    }
}