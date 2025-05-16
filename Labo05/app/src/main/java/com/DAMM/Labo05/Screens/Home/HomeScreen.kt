package com.DAMM.Labo05.Screens.Home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.DAMM.Labo05.Navigation.Sensor
import com.DAMM.Labo05.Navigation.Todo

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Starting Menu", style = MaterialTheme.typography.headlineSmall)
            Button(onClick = { navController.navigate(Todo) }) {
                Text("To do ")
            }
            Button(onClick = { navController.navigate(Sensor) }) {
                Text("Sensors")
            }
        }
    }
}