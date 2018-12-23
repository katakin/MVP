package com.katakin.mvp.di

import com.katakin.mvp.data.IPreferenceHelper
import javax.inject.Named

interface AppDependencies {
    @Named("User") fun provideUserPreferenceHelper(): IPreferenceHelper
}