package com.DAMM.Labo05.Screens.Sensor

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.DAMM.Labo05.ViewModels.SensorViewModel

@Composable
fun SensorScreen(viewModel: SensorViewModel = viewModel()) {
    val x by viewModel.x.collectAsState()
    val y by viewModel.y.collectAsState()
    val z by viewModel.z.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Acelerómetro:", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text("X: %.2f".format(x), style = MaterialTheme.typography.bodyLarge)
        Text("Y: %.2f".format(y), style = MaterialTheme.typography.bodyLarge)
        Text("Z: %.2f".format(z), style = MaterialTheme.typography.bodyLarge)
    }
}
