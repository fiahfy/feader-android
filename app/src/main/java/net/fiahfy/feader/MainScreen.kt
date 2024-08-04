package net.fiahfy.feader

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.fiahfy.feader.ui.theme.FeaderTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    FeaderTheme {
        Scaffold(
            topBar = { TopBar(navController = navController) },
            bottomBar = { BottomBar(navController = navController) }) {
            Box(modifier = Modifier.padding(it)) {
                NavHost(
                    navController = navController,
                    startDestination = BottomBarItem.Home.id
                ) {
                    composable(BottomBarItem.Home.id) { HomeScreen() }
                    composable(BottomBarItem.Settings.id) { SettingsScreen() }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
