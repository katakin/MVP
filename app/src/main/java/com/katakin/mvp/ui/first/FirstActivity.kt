package com.katakin.mvp.ui.first

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.katakin.mvp.R
import com.katakin.mvp.di.base.subcomponent
import com.katakin.mvp.di.first.FirstActivityComponent
import com.katakin.mvp.ui.base.BaseActivity
import com.katakin.mvp.ui.second.SecondActivity
import kotlinx.android.synthetic.main.activity_first.*
import javax.inject.Inject

class FirstActivity : BaseActivity(), FirstContract.View {

    @Inject
    lateinit var presenter: FirstContract.Presenter

    private var component by subcomponent(FirstActivityComponent::class.java) {
        firstBuilder().build()
    }

    override fun injectComponent() {
        component?.inject(this)
    }

    override fun rejectComponent() {
        component = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        presenter.onActivityCreate(this, savedInstanceState)
        next.setOnClickListener {
            presenter.onNextBtnPressed()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onActivityDestroy()
    }

    override fun initActionBar() {
        setSupportActionBar(toolbar)
        toolbar_title.text = toolbar.title
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    @SuppressLint("SetTextI18n")
    override fun initViewText() {
        view_id.text = "First View ID = ${this.hashCode()}"
    }

    @SuppressLint("SetTextI18n")
    override fun initPresenterText(hashCode: Int) {
        presenter_id.text = "First Presenter ID = $hashCode"
    }

    override fun initTreeComponent(text: String) {
        tree_component.text = text
    }

    override fun showSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
    }
}