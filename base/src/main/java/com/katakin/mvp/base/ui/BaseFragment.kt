package com.katakin.mvp.base.ui

import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {

    private var isInSaveState: Boolean = false

    override fun onStart() {
        super.onStart()
        isInSaveState = false
    }

    override fun onResume() {
        super.onResume()
        isInSaveState = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        isInSaveState = true
    }

    open fun onBackPressed(): Boolean = false

    protected fun isDestroy(): Boolean {
        if (activity?.isFinishing == true) {
            return true
        }

        // When we rotate device isRemoving() return true for fragment placed in backstack
        // http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving
        if (isInSaveState) {
            isInSaveState = false
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