package com.company.app.ui.activities.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.company.app.ui.activities.onboarding.fragments.OnboardingFragmentOne
import com.company.app.ui.activities.onboarding.fragments.OnboardingFragmentThree
import com.company.app.ui.activities.onboarding.fragments.OnboardingFragmentTwo

class OnboardingFragmentsAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OnboardingFragmentOne()
            1 -> OnboardingFragmentTwo()
            else -> OnboardingFragmentThree()
        }
    }
}