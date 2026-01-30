package com.example.aplikacja_sieciowa
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.aplikacja_sieciowa.presentation.navigation.NavGraph
import org.koin.compose.KoinContext



@Composable
fun App() {
    MaterialTheme {

        KoinContext {
            NavGraph()
        }
    }
}