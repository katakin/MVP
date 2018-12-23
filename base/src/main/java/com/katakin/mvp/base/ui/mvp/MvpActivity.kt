package com.katakin.mvp.base.ui.mvp

import android.os.Bundle
import com.katakin.mvp.base.ui.BaseActivity
import javax.inject.Inject

abstract class MvpActivity<V : MvpView, P : MvpPresenter<V>> : BaseActivity(), MvpView {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        injectComponent()
        super.onCreate(savedInstanceState)
        onCreateView(savedInstanceState)
        presenter.onAttachView(getView())
        onPresenterAttached(savedInstanceState)
    }

    abstract fun injectComponent()

    abstract fun onCreateView(savedInstanceState: Bundle?)

    abstract fun getView(): V

    open fun onPresenterAttached(savedInstanceState: Bundle?) {}

    override fun onDestroy() {
        presenter.onDetachView()
        if (isFinishing) {
            presenter.onDestroy()
        }
        super.onDestroy()
    }
}