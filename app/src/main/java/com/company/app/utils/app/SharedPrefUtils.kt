package com.company.app.utils.app

import android.content.Context
import com.company.app.appbase.constants.AppConstants

class SharedPrefUtils(context: Context) {

    private val sharedPrefs = context.getSharedPreferences(AppConstants.SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
    private val editor = sharedPrefs.edit()

    /**
     * Setters
     */
    fun saveStringToPrefs(key: String, value: String?) {
        editor.putString(key, value)
        editor.apply()
    }

    fun saveStringSetToPrefs(key: String, value: Set<String>?) {
        editor.putStringSet(key, value)
        editor.apply()
    }

    fun saveBooleanToPrefs(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun saveLongToPrefs(key: String, value: Long) {
        editor.putLong(key, value)
        editor.apply()
    }

    fun saveIntToPrefs(key: String, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    fun saveFloatToPrefs(key: String, value: Float) {
        editor.putFloat(key, value)
        editor.apply()
    }

    fun removeFromPref(key: String) {
        editor.remove(key)
        editor.apply()
    }


    /**
     * Getters
     */
    fun getStringFromPrefs(key: String): String {
        return sharedPrefs.getString(key, "")!!
    }

    fun getStringSetFromPrefs(key: String): Set<String>? {
        return sharedPrefs.getStringSet(key, null)
    }

    fun getStringFromPrefs(key: String, defaultVal: String): String {
        return sharedPrefs.getString(key, defaultVal)!!
    }

    fun getStringFromPrefsNullable(key: String, defaultVal: String?): String? {
        return sharedPrefs.getString(key, defaultVal)
    }

    fun getBooleanFromPrefs(key: String, defaultVal: Boolean): Boolean {
        return try {
            sharedPrefs.getBoolean(key, defaultVal)
        } catch (e: Exception) {
            e.printStackTrace()
            defaultVal
        }
    }

    fun getLongFromPref(key: String): Long {
        return sharedPrefs.getLong(key, -1)
    }

    fun getIntFromPref(key: String, defValue: Int): Int {
        return sharedPrefs.getInt(key, defValue)
    }

    fun getFloatFromPref(key: String): Float {
        return sharedPrefs.getFloat(key, -1F)
    }


    /**
     * Remove
     */
    fun removeFromPrefs(key: String) {
        editor.remove(key)
        editor.apply()
    }

}