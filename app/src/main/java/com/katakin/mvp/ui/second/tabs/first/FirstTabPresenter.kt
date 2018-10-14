package com.katakin.mvp.ui.second.tabs.first

import java.lang.ref.WeakReference
import javax.inject.Inject

class FirstTabPresenter @Inject constructor() : FirstTabContract.Presenter {

    private var viewReference: WeakReference<FirstTabContract.View>? = null

    override fun onFragmentAttach(view: FirstTabContract.View) {
        viewReference = WeakReference(view)
    }

    override fun onVisibleToUser() {
        viewReference?.get()?.initViewText()
        viewReference?.get()?.initPresenterText(hashCode())
        viewReference?.get()?.initComponents()
    }

    override fun onInvisibleToUser() {}

    override fun onFragmentDetach() {
        viewReference?.clear()
        viewReference = null
    }
}