package com.DAMM.Labo05.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.DAMM.Labo05.Screens.Home.HomeScreen
import com.DAMM.Labo05.Screens.Sensor.SensorScreen
import com.DAMM.Labo05.Screens.Todo.ToDo
import com.DAMM.Labo05.ViewModel.TaskViewModel


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<Todo> {
            val viewModel: TaskViewModel = viewModel()
            ToDo( viewModel = viewModel)
        }
        composable<Sensor> {
            SensorScreen()
        }
    }
}
