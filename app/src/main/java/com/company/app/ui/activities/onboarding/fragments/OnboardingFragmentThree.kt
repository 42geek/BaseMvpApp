package com.company.app.ui.activities.onboarding.fragments

import android.view.View
import com.company.app.R
import com.company.app.appbase.injection.AppComponent
import com.company.app.databinding.FragmentOnboardingThreeBinding
import com.company.app.ui.fragments.base.BaseFragment

class OnboardingFragmentThree: BaseFragment<FragmentOnboardingThreeBinding>(true) {

    override fun getToolbarView(): View? {
        return null
    }

    override fun injectDependencies(appComponent: AppComponent) {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_onboarding_three
    }

    override fun initFragmentViews() {

    }
}