package com.example.aplikacja_sieciowa
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.aplikacja_sieciowa.di.appModule
import com.example.aplikacja_sieciowa.di.platformModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Startujemy Koin dla Androida
        // Używamy try-catch albo stopKoin, żeby nie wysypało się przy obrocie ekranu
        stopKoin()
        startKoin {
            androidContext(this@MainActivity)
            modules(appModule, platformModule)
        }
        setContent {
            App()
        }
    }
}