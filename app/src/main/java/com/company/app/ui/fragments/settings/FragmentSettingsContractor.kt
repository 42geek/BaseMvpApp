package com.company.app.ui.fragments.settings

interface FragmentSettingsContractor {

    interface View {

    }

    interface Presenter {
        fun subscribe()
        fun unsubscribe()
    }
}