package com.test.mvvmretrofit.di

import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun inject(app: App)
}