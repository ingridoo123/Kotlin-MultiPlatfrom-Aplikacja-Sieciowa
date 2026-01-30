package com.example.aplikacja_sieciowa.di
import com.example.aplikacja_sieciowa.data.remote.IRCSocketClient
import com.example.aplikacja_sieciowa.data.remote.IrcClient
import com.example.aplikacja_sieciowa.data.repository.IRCRepositoryImpl
import com.example.aplikacja_sieciowa.domain.repository.IRCRepository
import org.koin.dsl.module


val platformModule = module {
    single<IrcClient> { IRCSocketClient() }
    single<IRCRepository> { IRCRepositoryImpl(get()) }
}