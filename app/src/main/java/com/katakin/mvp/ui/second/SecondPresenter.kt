package com.katakin.mvp.ui.second

import android.os.Bundle
import com.katakin.mvp.di.base.scope.ActivityScope
import java.lang.ref.WeakReference
import javax.inject.Inject

@ActivityScope
class SecondPresenter @Inject constructor(

) : SecondContract.Presenter {

    private var viewReference: WeakReference<SecondContract.View>? = null

    override fun onActivityCreate(view: SecondContract.View, savedInstanceState: Bundle?) {
        viewReference = WeakReference(view)

        viewReference?.get()?.initActionBar()
        viewReference?.get()?.initViewPager()
        viewReference?.get()?.initBottomNavigation()
    }

    override fun onActivityDestroy() {
        viewReference?.clear()
        viewReference = null
    }

    override fun onBackPressed() {
        viewReference?.get()?.close()
    }
}