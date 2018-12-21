package com.katakin.mvp.ui.first

import android.os.Bundle
import android.os.Handler
import com.katakin.mvp.di.ComponentManager
import com.katakin.mvp.di.base.scope.ActivityScope
import java.lang.ref.WeakReference
import javax.inject.Inject

@ActivityScope
class FirstPresenter @Inject constructor() : FirstContract.Presenter {

    private var viewReference: WeakReference<FirstContract.View>? = null
    private val handler = Handler()

    override fun onActivityCreate(view: FirstContract.View, savedInstanceState: Bundle?) {
        viewReference = WeakReference(view)

        viewReference?.get()?.initActionBar()
    }

    override fun onStart() {
        viewReference?.get()?.initViewText()
        viewReference?.get()?.initPresenterText(hashCode())
        handler.postDelayed(
                { viewReference?.get()?.initTreeComponent(ComponentManager.getTreeComponent().toIndentedString().toString()) },
                1000
        )
    }

    override fun onActivityDestroy() {
        viewReference?.clear()
        viewReference = null
    }

    override fun onNextBtnPressed() {
        viewReference?.get()?.showSecondActivity()
    }
}