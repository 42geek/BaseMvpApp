package com.company.app.ui.fragments.settings

import com.company.app.data.repository.Repository
import javax.inject.Inject

class FragmentSettingsPresenter @Inject constructor(private val view: FragmentSettingsContractor.View,
                                                    private val repository: Repository): FragmentSettingsContractor.Presenter {


    override fun subscribe() {

    }

    override fun unsubscribe() {

    }
}