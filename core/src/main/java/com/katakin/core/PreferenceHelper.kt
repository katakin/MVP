package com.katakin.core

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

open class PreferenceHelper(context: Context) : IPreferenceHelper {

    open val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    override fun putString(key: String, value: String?) = preferences
        .edit()
        .putString(key, value)
        .apply()

    override fun getString(key: String, defValue: String?): String? = preferences.getString(key, defValue)

    override fun putBoolean(key: String, value: Boolean) = preferences
        .edit()
        .putBoolean(key, value)
        .apply()

    override fun getBoolean(key: String, defValue: Boolean): Boolean = preferences.getBoolean(key, defValue)

    override fun putInt(key: String, value: Int) = preferences
        .edit()
        .putInt(key, value)
        .apply()

    override fun getInt(key: String, defValue: Int): Int = preferences.getInt(key, defValue)

    override fun remove(key: String) = preferences
        .edit()
        .remove(key)
        .apply()

    override fun clear() = preferences
        .edit()
        .clear()
        .apply()
}