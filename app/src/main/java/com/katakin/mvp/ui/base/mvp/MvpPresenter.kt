package com.katakin.mvp.ui.base.mvp

interface MvpPresenter<V : MvpView> {
    fun onAttachView(view: V)

    fun onDetachView()

    fun onDestroy()
}