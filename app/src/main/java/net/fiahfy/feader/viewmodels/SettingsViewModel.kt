package net.fiahfy.feader.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val packageInfo = application.packageManager.getPackageInfo(application.packageName, 0)
    private val versionName = packageInfo.versionName ?: "Unknown"
    private val versionCode = packageInfo.longVersionCode.toInt()
    val version = "$versionName ($versionCode)"
}
