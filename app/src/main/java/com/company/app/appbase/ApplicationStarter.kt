package com.company.app.appbase

import android.app.Application
import com.company.app.appbase.injection.AppComponent
import com.company.app.appbase.injection.AppModule
import com.company.app.appbase.injection.DaggerAppComponent

class ApplicationStarter: Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var app: ApplicationStarter
    }

    override fun onCreate() {
        iniDagger()
        super.onCreate()
    }

    private fun iniDagger() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent.inject(this)
        app = this
    }
}