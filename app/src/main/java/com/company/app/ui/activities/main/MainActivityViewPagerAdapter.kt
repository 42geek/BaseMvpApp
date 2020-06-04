package com.company.app.ui.activities.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.company.app.R
import com.company.app.ui.fragments.home.FragmentHome
import com.company.app.ui.fragments.settings.FragmentSettings

class MainActivityViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentHome()
            else -> FragmentSettings()
        }
    }

    fun getFragmentTitleRes(position: Int): Int {
        return when (position) {
            0 -> R.string.fragment_title_home
            1 -> R.string.fragment_title_settings
            else -> R.string.app_name
        }
    }

    fun getFragmentIdBasedOnNavItemId(navItemId: Int): Int {
        return when (navItemId) {
            R.id.navigation_home -> 0
            R.id.navigation_settings -> 1
            else -> 0
        }
    }
}