package com.katakin.mvp.ui.second

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.MenuItem
import com.katakin.mvp.R
import com.katakin.mvp.di.base.subcomponent
import com.katakin.mvp.di.second.SecondActivityComponent
import com.katakin.mvp.ui.base.BaseActivity
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_second.*
import javax.inject.Inject

class SecondActivity : BaseActivity(), SecondContract.View {

    @Inject
    lateinit var presenter: SecondContract.Presenter

    @Inject
    lateinit var componentChangeSubject : PublishSubject<Boolean>

    private var component by subcomponent(
            SecondActivityComponent::class.java.simpleName,
            { secondBuilder().build() },
            { componentChangeSubject.onNext(true) }
    )

    override fun injectComponent() {
        component?.inject(this)
    }

    override fun rejectComponent() {
        component = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        presenter.onActivityCreate(this, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onActivityDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    override fun initActionBar() {
        setSupportActionBar(toolbar)
        toolbar_title.text = toolbar.title
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun initViewPager() {
        viewPager.adapter = SecondViewPagerAdapter(supportFragmentManager)
        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
//                bottom_navigation.selectedItemId = bottom_navigation.menu.getItem(position).itemId
            }
        })
    }

    override fun initBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.first_tab -> viewPager.currentItem = 0
                R.id.second_tab -> viewPager.currentItem = 1
                R.id.third_tab -> viewPager.currentItem = 2
                else -> viewPager.currentItem = 0
            }
            true
        }
    }

    override fun getCurrentFragment(): Fragment? {
        return (viewPager.adapter as? SecondViewPagerAdapter)?.getItem(viewPager.currentItem) ?: super.getCurrentFragment()
    }

    override fun close() {
        setResult(Activity.RESULT_OK)
        finish()
    }
}