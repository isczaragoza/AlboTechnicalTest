package com.albo.albotechnicaltest

import android.app.Application
import com.albo.albotechnicaltest.data.di.dataModule
import com.albo.albotechnicaltest.domain.di.domainModule
import com.albo.albotechnicaltest.framework.di.frameworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@App)
            // Load modules
            modules(frameworkModule, dataModule, domainModule)
        }
    }
}