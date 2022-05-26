package com.test.mvvmretrofit.di

import android.app.Application

class App : Application() {

    companion object{
        lateinit var instance: App
        private set
    }

    lateinit var appComponent: AppComponent
    private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        initComponent()
    }

    private fun initComponent() {
        appComponent = DaggerAppComponent.builder()
            .build()
        appComponent.inject(this)
    }
}