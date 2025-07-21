package com.globant.pretatit

import android.app.Application
import dagger.hilt.android.HiltAndroidApp // <-- Importă
import timber.log.Timber

@HiltAndroidApp // <-- ADAUGĂ ACEASTĂ ADNOTARE
class TodoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}