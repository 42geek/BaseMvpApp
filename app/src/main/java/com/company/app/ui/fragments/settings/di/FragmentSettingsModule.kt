package com.company.app.ui.fragments.settings.di

import com.company.app.appbase.injection.scope.PerFragment
import com.company.app.data.repository.AndroidDisposable
import com.company.app.data.repository.Repository
import com.company.app.ui.fragments.settings.FragmentSettingsContractor
import com.company.app.ui.fragments.settings.FragmentSettingsPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentSettingsModule(private val view: FragmentSettingsContractor.View) {

    @Provides
    @PerFragment
    fun provideView(): FragmentSettingsContractor.View = view

    @Provides
    @PerFragment
    fun providePresenter(repository: Repository): FragmentSettingsContractor.Presenter = FragmentSettingsPresenter(view, repository)

    @Provides
    @PerFragment
    fun provideAndroidDisposable(): AndroidDisposable = AndroidDisposable()

}