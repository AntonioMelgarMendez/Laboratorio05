package com.DAMM.Labo05.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.DAMM.Labo05.data.repository.AccelerometerRepository
import kotlinx.coroutines.flow.StateFlow

class SensorViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AccelerometerRepository(application.applicationContext)

    val x: StateFlow<Float> = repository.x
    val y: StateFlow<Float> = repository.y
    val z: StateFlow<Float> = repository.z

    override fun onCleared() {
        super.onCleared()
        repository.unregister()
    }
}
