package net.fiahfy.feader

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.fiahfy.feader.ui.theme.FeaderTheme

@Composable
fun MainScreen() {
    FeaderTheme {
        Scaffold(bottomBar = { BottomBar() }) { padding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(padding)
            )
        }
    }
}

@Composable
fun BottomBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
//                        Text(stringResource(R.string.bottom_navigation_home))
                Text("Home")
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            },
            label = {
//                        Text(stringResource(R.string.bottom_navigation_settings))
                Text("Settings")
            },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FeaderTheme {
        MainScreen()
    }
}
