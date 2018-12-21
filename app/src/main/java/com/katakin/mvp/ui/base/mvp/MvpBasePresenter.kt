package com.katakin.mvp.ui.base.mvp

import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class MvpBasePresenter<V : MvpView> : MvpPresenter<V> {

    private var viewReference: WeakReference<V>? = null
    private var firstViewAttach: Boolean = false

    private var compositeDetachDisposable: CompositeDisposable? = null
    private var compositeDestroyDisposable: CompositeDisposable? = null

    open fun onFirstViewAttach() {}

    open val view: V? get() = viewReference?.get()

    @CallSuper
    override fun onAttachView(view: V) {
        viewReference = WeakReference(view)

        if (firstViewAttach) {
            firstViewAttach = true
            onFirstViewAttach()
        }
    }

    @CallSuper
    override fun onDetachView() {
        viewReference?.clear()
        viewReference = null

        compositeDetachDisposable?.clear()
    }

    @CallSuper
    override fun onDestroy() {
        compositeDestroyDisposable?.clear()
    }

    fun Disposable.disposeOnDetach() {
        if (view == null) {
            dispose()
        } else {
            getDetachDisposable().add(this)
        }
    }

    fun Disposable.disposeOnDestroy() {
        getDestroyDisposable().add(this)
    }

    private fun getDetachDisposable(): CompositeDisposable {
        if (compositeDetachDisposable == null || compositeDetachDisposable!!.isDisposed) {
            compositeDetachDisposable = CompositeDisposable()
        }
        return compositeDetachDisposable as CompositeDisposable
    }

    private fun getDestroyDisposable(): CompositeDisposable {
        if (compositeDestroyDisposable == null || compositeDestroyDisposable!!.isDisposed) {
            compositeDestroyDisposable = CompositeDisposable()
        }
        return compositeDestroyDisposable as CompositeDisposable
    }
}