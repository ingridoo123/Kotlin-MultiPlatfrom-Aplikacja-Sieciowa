package com.example.aplikacja_sieciowa.util
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel


open class ViewModel {

    val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    open fun onCleared() {
        viewModelScope.cancel()
    }
}