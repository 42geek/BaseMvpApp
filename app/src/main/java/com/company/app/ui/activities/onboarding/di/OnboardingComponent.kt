package com.company.app.ui.activities.onboarding.di

import com.company.app.appbase.injection.scope.PerActivity
import com.company.app.ui.activities.onboarding.OnboardingActivity
import com.company.app.ui.activities.onboarding.OnboardingPresenter
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [OnboardingModule::class])
interface OnboardingComponent {

    fun inject(activity: OnboardingActivity)
    fun inject(presenter: OnboardingPresenter)

}