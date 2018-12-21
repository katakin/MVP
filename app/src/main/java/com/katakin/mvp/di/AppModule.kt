package com.katakin.mvp.di

import android.content.Context
import com.katakin.core.IPreferenceHelper
import com.katakin.core.UserPreferenceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideUserPreferenceHelper(context: Context): IPreferenceHelper = UserPreferenceHelper(context)
}