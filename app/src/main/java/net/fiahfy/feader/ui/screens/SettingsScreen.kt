package net.fiahfy.feader.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.fiahfy.feader.viewmodels.SettingsViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = viewModel()) {
    SettingsScreen(version = viewModel.version)
}

@Composable
fun SettingsScreen(version: String) {
    LazyColumn {
        item {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Version", style = MaterialTheme.typography.titleLarge)
                Text(text = version, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(version = "1.0.0 (1)")
}
