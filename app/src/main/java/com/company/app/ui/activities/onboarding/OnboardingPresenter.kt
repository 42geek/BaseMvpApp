package com.company.app.ui.activities.onboarding

import com.company.app.data.repository.AndroidDisposable
import javax.inject.Inject


class OnboardingPresenter @Inject constructor(private val view: OnboardingContractor.View,
                                              private val androidDisposable: AndroidDisposable): OnboardingContractor.Presenter {

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }
}