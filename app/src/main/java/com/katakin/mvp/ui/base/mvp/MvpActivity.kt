package com.katakin.mvp.ui.base.mvp

import android.os.Bundle
import com.katakin.mvp.ui.base.BaseActivity
import javax.inject.Inject

abstract class MvpActivity<V : MvpView, P : MvpPresenter<V>> : BaseActivity(), MvpView {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
        presenter.onAttachView(getView())
        onCreateView(savedInstanceState)
    }

    abstract fun injectComponent()

    abstract fun onCreateView(savedInstanceState: Bundle?)

    abstract fun getView(): V

    override fun onDestroy() {
        presenter.onDetachView()
        if (isFinishing) {
            presenter.onDestroy()
        }
        super.onDestroy()
    }
}