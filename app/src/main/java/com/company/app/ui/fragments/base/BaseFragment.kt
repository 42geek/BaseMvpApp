package com.company.app.ui.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.BarUtils
import com.company.app.appbase.ApplicationStarter
import com.company.app.appbase.injection.AppComponent

abstract class BaseFragment<B: ViewDataBinding>(private val isFullScreenFragment: Boolean): Fragment() {

    protected lateinit var dataBinding: B

    abstract fun getToolbarView(): View?

    abstract fun injectDependencies(appComponent: AppComponent)

    abstract fun getLayoutId(): Int

    abstract fun initFragmentViews()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies(ApplicationStarter.appComponent)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        initFragmentViews()
        return dataBinding.root
    }

    override fun onResume() {
        super.onResume()

        if (isFullScreenFragment && getToolbarView() != null) {
            val toolbar = getToolbarView()!!
            toolbar.setPadding(toolbar.paddingLeft, BarUtils.getStatusBarHeight(), toolbar.paddingRight, toolbar.paddingBottom)
        }
    }

}