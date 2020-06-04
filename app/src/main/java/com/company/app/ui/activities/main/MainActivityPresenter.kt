package com.company.app.ui.activities.main

import javax.inject.Inject

class MainActivityPresenter @Inject constructor(var view : MainActivityContractor.View): MainActivityContractor.Presenter {


    override fun subscribe() {

    }

    override fun unsubscribe() {

    }
}