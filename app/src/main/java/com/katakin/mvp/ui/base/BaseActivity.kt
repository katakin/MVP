package com.katakin.mvp.ui.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onBackPressed() {
        val fragment = getCurrentFragment()

        if (fragment is BaseFragment && fragment.onBackPressed()) {
            return
        }
        super.onBackPressed()
    }

    open fun getCurrentFragment(): Fragment? = null
}