package com.company.app.ui.activities.main


interface MainActivityContractor {

    interface View {

    }

    interface Presenter {
        fun subscribe()
        fun unsubscribe()
    }
}