package com.katakin.core

import android.content.Context
import android.content.SharedPreferences

class UserPreferenceHelper(context: Context): PreferenceHelper(context) {

    override val preferences: SharedPreferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)

    companion object {
        private const val USER_PREFERENCES = "user_preferences"
    }
}