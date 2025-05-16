package com.DAMM.Labo05.Screens.Todo

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.DAMM.Labo05.ViewModel.TaskViewModel
import com.DAMM.Labo05.Components.List
import com.DAMM.Labo05.Components.AddTaskDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDo(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsState()
    val showDialog by viewModel.showDialog

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Task Management") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "Task List",
                        tint = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EE),
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.setShowDialog(true) },
                containerColor = Color(0xFF6200EE),
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { paddingValues ->
        List(
            tasks = tasks,
            onTaskDelete = viewModel::deleteTask,
            onTaskToggle = viewModel::toggleTaskComplete,
            modifier = Modifier.padding(paddingValues)
        )

        if (showDialog) {
            AddTaskDialog(
                onDismiss = { viewModel.setShowDialog(false) },
                onAddTask = viewModel::addTask
            )
        }
    }
}