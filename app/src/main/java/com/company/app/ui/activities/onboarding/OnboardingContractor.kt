package com.company.app.ui.activities.onboarding

interface OnboardingContractor {

    interface View {

    }

    interface Presenter {
        fun subscribe()
        fun unsubscribe()
    }

}