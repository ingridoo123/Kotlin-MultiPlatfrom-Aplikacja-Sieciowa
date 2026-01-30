package com.example.aplikacja_sieciowa.di
import com.example.aplikacja_sieciowa.presentation.connect.ConnectViewModel
import com.example.aplikacja_sieciowa.presentation.chat.ChatViewModel



import org.koin.dsl.module
val appModule = module {

    factory { ConnectViewModel(get()) }
    factory { ChatViewModel(get()) }
}