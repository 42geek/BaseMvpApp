package com.company.app.ui.fragments.settings.di

import com.company.app.appbase.injection.scope.PerFragment
import com.company.app.ui.fragments.settings.FragmentSettings
import com.company.app.ui.fragments.settings.FragmentSettingsPresenter
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [FragmentSettingsModule::class])
interface FragmentSettingsComponent {

    fun inject(fragment: FragmentSettings)
    fun inject(presenter: FragmentSettingsPresenter)

}