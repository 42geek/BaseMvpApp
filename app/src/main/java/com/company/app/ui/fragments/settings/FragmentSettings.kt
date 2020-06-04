package com.company.app.ui.fragments.settings

import android.view.View
import com.company.app.R
import com.company.app.appbase.injection.AppComponent
import com.company.app.databinding.FragmentSettignsBinding
import com.company.app.ui.fragments.base.BaseFragment
import com.company.app.ui.fragments.settings.di.FragmentSettingsModule

class FragmentSettings: BaseFragment<FragmentSettignsBinding>(false), FragmentSettingsContractor.View {

    override fun getToolbarView(): View? {
        return null
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(FragmentSettingsModule(this)).inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_settigns
    }

    override fun initFragmentViews() {

    }
}