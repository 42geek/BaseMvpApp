package com.company.app.ui.activities.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.company.app.ui.activities.main.MainActivity
import com.company.app.R
import com.company.app.appbase.ApplicationStarter
import com.company.app.appbase.constants.AppConstants
import com.company.app.appbase.settings.UserSettings
import com.company.app.ui.activities.onboarding.OnboardingActivity
import javax.inject.Inject

/**
 * This is the entry point for the app, the code will check the user settings to show an onboarding or just start the app.
 */
class InitActivity: AppCompatActivity() {

    @Inject
    internal lateinit var userSettings: UserSettings

    init {
        ApplicationStarter.appComponent.inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        //Check if should show onboarding based on the current settings and start the app
        val intent = if (userSettings.getIsFirstTime() && AppConstants.SHOULD_SHOW_ONBOARDING) {
            Intent(this, OnboardingActivity::class.java)
        } else {
            Intent(this, MainActivity::class.java)
        }

        startActivity(intent)
        finish()
    }

}