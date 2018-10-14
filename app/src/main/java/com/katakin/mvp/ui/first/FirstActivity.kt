package com.katakin.mvp.ui.first

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.katakin.mvp.R
import com.katakin.mvp.di.ComponentManager
import com.katakin.mvp.di.base.subcomponent
import com.katakin.mvp.di.first.FirstActivityComponent
import com.katakin.mvp.ui.base.BaseActivity
import com.katakin.mvp.ui.second.SecondActivity
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_first.*
import javax.inject.Inject

class FirstActivity : BaseActivity(), FirstContract.View {

    @Inject
    lateinit var presenter: FirstContract.Presenter

    @Inject
    lateinit var componentChangeSubject : PublishSubject<Boolean>

    private var disposable: Disposable? = null

    private var component by subcomponent(
            FirstActivityComponent::class.java.simpleName,
            { firstBuilder().build() },
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
        setContentView(R.layout.activity_first)
        presenter.onActivityCreate(this, savedInstanceState)
        next.setOnClickListener {
            presenter.onNextBtnPressed()
        }
        disposable = componentChangeSubject.subscribe {
            initComponents()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onActivityDestroy()
        disposable?.dispose()
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

    override fun initComponents() {
        components.text = "${ComponentManager.getComponents().toIndentedString()}"
    }

    override fun showSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
    }
}