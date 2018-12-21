package com.katakin.mvp.ui.second.tabs.second

import android.os.Handler
import com.katakin.mvp.di.ComponentManager
import java.lang.ref.WeakReference
import javax.inject.Inject

class SecondTabPresenter @Inject constructor() : SecondTabContract.Presenter {

    private var viewReference: WeakReference<SecondTabContract.View>? = null
    private val handler = Handler()

    override fun onFragmentAttach(view: SecondTabContract.View) {
        viewReference = WeakReference(view)
    }

    override fun onVisibleToUser() {
        viewReference?.get()?.initViewText()
        viewReference?.get()?.initPresenterText(hashCode())
        handler.postDelayed(
                { viewReference?.get()?.initTreeComponent(ComponentManager.getTreeComponent().toIndentedString().toString()) },
                1000
        )
    }

    override fun onInvisibleToUser() {}

    override fun onFragmentDetach() {
        viewReference?.clear()
        viewReference = null
    }
}