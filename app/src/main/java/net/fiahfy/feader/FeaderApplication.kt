package net.fiahfy.feader

import android.app.Application
import timber.log.Timber

class FeaderApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}
