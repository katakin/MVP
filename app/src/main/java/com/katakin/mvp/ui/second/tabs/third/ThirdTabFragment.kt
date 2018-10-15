package com.katakin.mvp.ui.second.tabs.third

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.katakin.mvp.R
import com.katakin.mvp.di.base.subcomponent
import com.katakin.mvp.di.second.SecondActivityComponent
import com.katakin.mvp.di.second.tabs.third.ThirdTabComponent
import com.katakin.mvp.ui.base.ViewPagerFragment
import kotlinx.android.synthetic.main.fragment_third_tab.*
import javax.inject.Inject

class ThirdTabFragment : ViewPagerFragment(), ThirdTabContract.View {

    companion object {
        fun newInstance(): ThirdTabFragment {
            return ThirdTabFragment()
        }
    }

    @Inject
    lateinit var presenter: ThirdTabContract.Presenter

    private var component by subcomponent(ThirdTabComponent::class.java, SecondActivityComponent::class.java) {
        thirdTabBuilder().build()
    }

    override fun injectComponent() {
        component?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_third_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onFragmentAttach(this)
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
    }

    @SuppressLint("SetTextI18n")
    override fun initViewText() {
        view_id.text = "Third Tab View ID = ${this.hashCode()}"
    }

    @SuppressLint("SetTextI18n")
    override fun initPresenterText(hashCode: Int) {
        presenter_id.text = "Third Tab Presenter ID = $hashCode"
    }

    override fun initComponents() {
        components.text = "${ComponentManager.getComponents().toIndentedString()}"
    }
}