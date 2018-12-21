package com.katakin.core.di

import com.katakin.core.IPreferenceHelper

interface AppDependencies {
    fun proxyProvideUserPreferenceHelper(): IPreferenceHelper
}