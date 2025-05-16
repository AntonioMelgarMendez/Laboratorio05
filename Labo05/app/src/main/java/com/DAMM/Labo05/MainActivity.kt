package com.DAMM.Labo05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.DAMM.Labo05.Navigation.Navigation
import com.DAMM.Labo05.ui.theme.Labo05Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labo05Theme {
                Navigation()
            }
        }
    }
}