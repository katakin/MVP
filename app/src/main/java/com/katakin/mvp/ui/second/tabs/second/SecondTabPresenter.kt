package com.katakin.mvp.ui.second.tabs.second

import java.lang.ref.WeakReference
import javax.inject.Inject

class SecondTabPresenter @Inject constructor() : SecondTabContract.Presenter {

    private var viewReference: WeakReference<SecondTabContract.View>? = null

    override fun onFragmentAttach(view: SecondTabContract.View) {
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