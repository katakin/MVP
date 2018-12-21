package com.katakin.mvp.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {

    protected abstract fun injectComponent()
    protected open fun rejectComponent() {}

    private var mIsStateSaved: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        injectComponent()
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        mIsStateSaved = false
    }

    override fun onResume() {
        super.onResume()
        mIsStateSaved = false
    }

    override fun onDestroy() {
        if (isDestroy()) {
            rejectComponent()
        }
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mIsStateSaved = true
    }

    open fun onBackPressed(): Boolean = false

    private fun isDestroy(): Boolean {
        if (activity?.isFinishing == true) {
            return true
        }

        // When we rotate device isRemoving() return true for fragment placed in backstack
        // http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving
        if (mIsStateSaved) {
            mIsStateSaved = false
            return false
        }

        // See https://github.com/Arello-Mobile/Moxy/issues/24
        var anyParentIsRemoving = false
        var parent = parentFragment
        while (!anyParentIsRemoving && parent != null) {
            anyParentIsRemoving = parent.isRemoving
            parent = parent.parentFragment
        }

        if (isRemoving || anyParentIsRemoving) {
            return true
        }

        return false
    }
}