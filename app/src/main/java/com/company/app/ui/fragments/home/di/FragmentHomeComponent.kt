package com.company.app.ui.fragments.home.di

import com.company.app.appbase.injection.scope.PerFragment
import com.company.app.ui.fragments.home.FragmentHome
import com.company.app.ui.fragments.home.FragmentHomePresenter
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [FragmentHomeModule::class])
interface FragmentHomeComponent {

    fun inject(fragment: FragmentHome)
    fun inject(presenter: FragmentHomePresenter)

}