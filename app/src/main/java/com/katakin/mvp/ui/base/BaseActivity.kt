package com.katakin.mvp.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun injectComponent()
    protected open fun rejectComponent() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        injectComponent()
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        if (isFinishing) {
            rejectComponent()
        }
        super.onDestroy()
    }

    override fun onBackPressed() {
        val fragment = getCurrentFragment()

        if (fragment is BaseFragment && fragment.onBackPressed()) {
            return
        }
        super.onBackPressed()
    }

    open fun getCurrentFragment(): Fragment? = null
}