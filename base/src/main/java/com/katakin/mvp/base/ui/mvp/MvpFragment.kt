package com.katakin.mvp.base.ui.mvp

import android.os.Bundle
import android.view.View
import com.katakin.mvp.base.ui.BaseFragment
import javax.inject.Inject

abstract class MvpFragment<V : MvpView, P : MvpBasePresenter<V>> : BaseFragment(), MvpView {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        injectComponent()
        super.onCreate(savedInstanceState)
    }

    abstract fun injectComponent()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttachView(getFragment())
        onPresenterAttached(savedInstanceState)
    }

    abstract fun getFragment(): V

    open fun onPresenterAttached(savedInstanceState: Bundle?) {}

    override fun onDestroyView() {
        presenter.onDetachView()
        super.onDestroyView()
    }

    override fun onDestroy() {
        if (isDestroy()) {
            presenter.onDestroy()
        }
        super.onDestroy()
    }
}