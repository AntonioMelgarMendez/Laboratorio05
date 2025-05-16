package com.damm.labo06

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.damm.labo06.Data.Movie
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun fetchDataFromDatabase(): List<Movie> {
    delay(3000)
    return listOf(
        Movie(1, "Minecraft", "Walter"),
        Movie(2, "The Simpsons", "Matt Groening")
    )
}

@Composable
fun ShowMovies() {
    var isLoading by remember { mutableStateOf(false) }
    val dataState = remember { mutableStateOf<List<Movie>?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }
    val lifecycleScope = LocalLifecycleOwner.current.lifecycleScope

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(onClick = {
                isLoading = true
                lifecycleScope.launch {
                    val movies = fetchDataFromDatabase()
                    dataState.value = movies
                    isLoading = false
                    snackbarHostState.showSnackbar("Datos cargados con éxito")
                }
            }, modifier= Modifier.padding(10.dp)) {
                Text(text = "Cargar Películas")
            }

            if (isLoading) {
                CircularProgressIndicator()
            }

            if (dataState.value == null && !isLoading) {
                Text("No hay películas cargadas.")
            }

            if(dataState.value!=null && !isLoading) {
                dataState.value?.let { movies ->
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        movies.forEach { movie ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 4.dp),
                                elevation = CardDefaults.cardElevation(4.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        "ID: ${movie.id}",
                                        style = MaterialTheme.typography.labelMedium
                                    )
                                    Text(movie.title, style = MaterialTheme.typography.titleMedium)
                                    Text(
                                        movie.description,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
