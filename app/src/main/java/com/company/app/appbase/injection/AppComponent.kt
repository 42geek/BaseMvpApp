package com.company.app.appbase.injection

import com.company.app.appbase.ApplicationStarter
import com.company.app.ui.activities.base.InitActivity
import com.company.app.appbase.injection.scope.ApplicationScope
import com.company.app.data.repository.di.RepositoryModule
import com.company.app.ui.fragments.home.di.FragmentHomeComponent
import com.company.app.ui.activities.main.di.MainActivityComponent
import com.company.app.ui.activities.main.di.MainActivityModule
import com.company.app.ui.fragments.settings.di.FragmentSettingsComponent
import com.company.app.ui.fragments.home.di.FragmentHomeModule
import com.company.app.ui.activities.onboarding.di.OnboardingComponent
import com.company.app.ui.activities.onboarding.di.OnboardingModule
import com.company.app.ui.fragments.settings.di.FragmentSettingsModule
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class, RepositoryModule::class])
interface AppComponent {

    //Some base injections:
    fun inject(app: ApplicationStarter)

    //Activities:
    fun inject(activity: InitActivity)

    //Sub Components:
    fun plus(module: OnboardingModule): OnboardingComponent
    fun plus(module: MainActivityModule): MainActivityComponent
    fun plus(module: FragmentHomeModule): FragmentHomeComponent
    fun plus(module: FragmentSettingsModule): FragmentSettingsComponent

}