package com.katakin.mvp.ui.base.mvp

import android.os.Bundle
import android.view.View
import com.katakin.mvp.ui.base.BaseFragment
import javax.inject.Inject

abstract class MvpFragment<V : MvpView, P : MvpBasePresenter<V>> : BaseFragment(), MvpView {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
    }

    abstract fun injectComponent()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttachView(getFragmentView())
    }

    abstract fun getFragmentView(): V

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDetachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isDestroy()) {
            presenter.onDestroy()
        }
    }
}