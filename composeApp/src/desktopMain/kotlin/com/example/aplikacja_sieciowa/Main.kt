package com.example.aplikacja_sieciowa
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.aplikacja_sieciowa.di.appModule
import com.example.aplikacja_sieciowa.di.platformModule
import org.koin.core.context.startKoin


fun main() = application {
    // Startujemy Koin dla Desktopa
    // Robimy to raz, przed uruchomieniem okna
    try {
        startKoin {
            modules(appModule, platformModule)
        }
    } catch (e: Exception) {
        // Ignorujemy błąd, jeśli Koin już wystartował
    }
    Window(onCloseRequest = ::exitApplication, title = "Aplikacja Sieciowa") {
        App()
    }
}