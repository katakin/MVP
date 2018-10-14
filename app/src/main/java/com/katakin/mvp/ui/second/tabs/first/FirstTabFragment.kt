package com.katakin.mvp.ui.second.tabs.first

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.katakin.mvp.R
import com.katakin.mvp.di.ComponentManager
import com.katakin.mvp.di.base.subcomponent
import com.katakin.mvp.di.second.SecondActivityComponent
import com.katakin.mvp.di.second.tabs.first.FirstTabComponent
import com.katakin.mvp.ui.base.ViewPagerFragment
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_first_tab.*
import javax.inject.Inject

class FirstTabFragment : ViewPagerFragment(), FirstTabContract.View {

    companion object {
        fun newInstance(): FirstTabFragment {
            return FirstTabFragment()
        }
    }

    @Inject
    lateinit var presenter: FirstTabContract.Presenter

    @Inject
    lateinit var componentChangeSubject : PublishSubject<Boolean>

    private var disposable: Disposable? = null

    private var component by subcomponent<FirstTabComponent, SecondActivityComponent>(
            FirstTabComponent::class.java.simpleName,
            SecondActivityComponent::class.java.simpleName,
            { firstTabBuilder().build() },
            { componentChangeSubject.onNext(true) }
    )

    override fun injectComponent() {
        component?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onFragmentAttach(this)
        disposable = componentChangeSubject.subscribe {
            initComponents()
        }
    }

    override fun onVisibleToUser() {
        presenter.onVisibleToUser()
    }

    override fun onInvisibleToUser() {
        presenter.onInvisibleToUser()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onFragmentDetach()
        disposable?.dispose()
    }

    @SuppressLint("SetTextI18n")
    override fun initViewText() {
        view_id.text = "First Tab View ID = ${this.hashCode()}"
    }

    @SuppressLint("SetTextI18n")
    override fun initPresenterText(hashCode: Int) {
        presenter_id.text = "First Tab Presenter ID = $hashCode"
    }

    override fun initComponents() {
        components.text = "${ComponentManager.getComponents().toIndentedString()}"
    }
}