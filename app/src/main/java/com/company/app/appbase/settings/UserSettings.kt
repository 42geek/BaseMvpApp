package com.company.app.appbase.settings

import com.company.app.appbase.constants.AppConstants
import com.company.app.utils.app.SharedPrefUtils
import javax.inject.Inject

class UserSettings @Inject constructor(private val sharedPrefUtils: SharedPrefUtils) {

    /**
     * Is First Time In App:
     */
    fun getIsFirstTime(): Boolean {
        return sharedPrefUtils.getBooleanFromPrefs(AppConstants.SHARED_PREF_KEY_USER_SETTINGS_FIRST_TIME, true)
    }

    fun setIsFirstTime(value: Boolean) {
        sharedPrefUtils.saveBooleanToPrefs(AppConstants.SHARED_PREF_KEY_USER_SETTINGS_FIRST_TIME, value)
    }

}