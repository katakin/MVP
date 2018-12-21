package com.katakin.mvp.ui.base

abstract class ViewPagerFragment : BaseFragment() {
    private var isVisibleToUser: Boolean = false

    override fun onStart() {
        super.onStart()
        if (isVisibleToUser) {
            onVisibleToUser()
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        if (isResumed) {
            if (isVisibleToUser) {
                onVisibleToUser()
            } else {
                onInvisibleToUser()
            }
        }
    }

    abstract fun onVisibleToUser()

    abstract fun onInvisibleToUser()
}