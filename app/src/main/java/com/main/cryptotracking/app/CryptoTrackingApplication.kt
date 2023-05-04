package com.main.cryptotracking.app

import android.app.Application
import com.main.core_datasource.di.dataStoreModule
import com.main.cryptotracking.di.applicationModule
import com.main.feat_onboarding.di.onBoardingModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class CryptoTrackingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@CryptoTrackingApplication)
            modules(listOf(dataStoreModule, onBoardingModule, applicationModule))
        }
    }
}