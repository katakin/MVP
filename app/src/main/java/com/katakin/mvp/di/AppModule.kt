package com.katakin.mvp.di

import android.content.Context
import com.katakin.mvp.App
import com.katakin.mvp.di.first.FirstActivityComponent
import com.katakin.mvp.di.second.SecondActivityComponent
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.PublishSubject
import javax.inject.Singleton

@Module(subcomponents = [
    FirstActivityComponent::class,
    SecondActivityComponent::class
])
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: App): Context = app

    @Singleton
    @Provides
    fun provideComponentChangeSubject(): PublishSubject<Boolean> = PublishSubject.create<Boolean>()
}