package com.katakin.mvp.base.ui.mvp

interface MvpPresenter<V : MvpView> {
    fun onAttachView(view: V)

    fun onDetachView()

    fun onDestroy()
}