package com.example.aplikacja_sieciowa.data.remote
import com.example.aplikacja_sieciowa.data.model.Channel
import com.example.aplikacja_sieciowa.data.model.ConnectionState
import com.example.aplikacja_sieciowa.data.model.IRCCommand
import com.example.aplikacja_sieciowa.data.model.Message
import kotlinx.coroutines.flow.StateFlow


interface IrcClient {
    // Strumienie danych (to co widzi UI)
    val connectionState: StateFlow<ConnectionState>
    val messages: StateFlow<List<Message>>
    val channels: StateFlow<List<Channel>>
    val currentNickname: StateFlow<String?>
    val serverResponses: StateFlow<List<String>>
    val channelUsers: StateFlow<Map<String, List<String>>>
    // Funkcje (akcje)
    suspend fun connect(host: String, port: Int)
    suspend fun sendCommand(command: IRCCommand)
    fun disconnect()
    fun clearMessages()
    fun addLocalMessage(message: Message)
}