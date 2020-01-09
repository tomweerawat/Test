package com.example.ookbee

import android.app.Application
import com.example.ookbee.di.applicationModule
import com.example.ookbee.di.feedModule
import com.example.ookbee.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber



class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        // start Koin!
        startKoin {
            // Android context
            androidContext(this@MainApplication)
            androidLogger(Level.DEBUG)
            androidFileProperties()
            // modules
            modules(applicationModule +feedModule+networkModule)
        }
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}