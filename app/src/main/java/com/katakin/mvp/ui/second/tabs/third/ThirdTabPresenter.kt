package com.katakin.mvp.ui.second.tabs.third

import java.lang.ref.WeakReference
import javax.inject.Inject

class ThirdTabPresenter @Inject constructor() : ThirdTabContract.Presenter {

    private var viewReference: WeakReference<ThirdTabContract.View>? = null

    override fun onFragmentAttach(view: ThirdTabContract.View) {
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