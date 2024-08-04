package net.fiahfy.feader.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import net.fiahfy.feader.R

enum class BottomBarItem(
    val id: String,
    val icon: ImageVector,
    val resId: Int,
) {
    Home(id = "home", icon = Icons.Default.Home, resId = R.string.bottom_navigation_home),
    Settings(
        id = "settings",
        icon = Icons.Default.Settings,
        resId = R.string.bottom_navigation_settings
    )
}
