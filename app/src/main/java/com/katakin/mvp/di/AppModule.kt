package com.katakin.mvp.di

import android.content.Context
import com.katakin.mvp.data.IPreferenceHelper
import com.katakin.mvp.data.PreferenceHelper
import com.katakin.mvp.data.UserPreferenceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    @Named("Default")
    fun provideDefaultPreferenceHelper(context: Context): IPreferenceHelper = PreferenceHelper(context)

    @Singleton
    @Provides
    @Named("User")
    fun provideUserPreferenceHelper(context: Context): IPreferenceHelper = UserPreferenceHelper(context)
}