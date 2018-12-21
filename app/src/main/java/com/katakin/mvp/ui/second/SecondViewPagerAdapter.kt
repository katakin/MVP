package com.katakin.mvp.ui.second

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.katakin.mvp.ui.base.ViewPagerFragment
import com.katakin.mvp.ui.second.tabs.first.FirstTabFragment
import com.katakin.mvp.ui.second.tabs.second.SecondTabFragment
import com.katakin.mvp.ui.second.tabs.third.ThirdTabFragment

class SecondViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): ViewPagerFragment {
        return when(position) {
            0 -> FirstTabFragment.newInstance()
            1 -> SecondTabFragment.newInstance()
            2 -> ThirdTabFragment.newInstance()
            else -> FirstTabFragment.newInstance()
        }
    }

    override fun getCount(): Int = 3
}