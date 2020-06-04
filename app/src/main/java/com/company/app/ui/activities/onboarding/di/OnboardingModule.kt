package com.company.app.ui.activities.onboarding.di

import com.company.app.appbase.injection.scope.PerActivity
import com.company.app.data.repository.AndroidDisposable
import com.company.app.ui.activities.onboarding.OnboardingContractor
import com.company.app.ui.activities.onboarding.OnboardingPresenter
import dagger.Module
import dagger.Provides

@Module
class OnboardingModule(private val view: OnboardingContractor.View) {

    @Provides
    @PerActivity
    fun provideView(): OnboardingContractor.View = view

    @Provides
    @PerActivity
    fun providePresenter(androidDisposable: AndroidDisposable): OnboardingContractor.Presenter = OnboardingPresenter(view, androidDisposable)

    @Provides
    @PerActivity
    fun provideAndroidDisposable(): AndroidDisposable = AndroidDisposable()

}