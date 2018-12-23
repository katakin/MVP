package com.katakin.mvp.data

interface IPreferenceHelper {
    fun putString(key: String, value: String?)

    fun getString(key: String, defValue: String? = ""): String?

    fun putBoolean(key: String, value: Boolean)

    fun getBoolean(key: String, defValue: Boolean = false): Boolean

    fun putInt(key: String, value: Int)

    fun getInt(key: String, defValue: Int = -1): Int

    fun remove(key: String)

    fun clear()
}