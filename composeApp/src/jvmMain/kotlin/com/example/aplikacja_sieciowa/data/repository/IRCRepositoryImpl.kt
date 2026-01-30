package com.example.aplikacja_sieciowa.data.repository

import com.example.aplikacja_sieciowa.data.model.Channel
import com.example.aplikacja_sieciowa.data.model.ConnectionState
import com.example.aplikacja_sieciowa.data.model.IRCCommand
import com.example.aplikacja_sieciowa.data.model.Message
import com.example.aplikacja_sieciowa.data.remote.IRCSocketClient
import com.example.aplikacja_sieciowa.data.remote.IrcClient
import com.example.aplikacja_sieciowa.domain.repository.IRCRepository
import kotlinx.coroutines.flow.StateFlow


class IRCRepositoryImpl(private val client: IrcClient) : IRCRepository {

    override val connectionState: StateFlow<ConnectionState> = client.connectionState
    override val messages: StateFlow<List<Message>> = client.messages
    override val channels: StateFlow<List<Channel>> = client.channels
    override val currentNickname: StateFlow<String?> = client.currentNickname
    override val serverResponses: StateFlow<List<String>> = client.serverResponses
    override val channelUsers: StateFlow<Map<String, List<String>>> = client.channelUsers

    override suspend fun connect(host: String, port: Int) {
        client.connect(host, port)
    }

    override suspend fun setNickname(nickname: String) {
        client.sendCommand(IRCCommand.Nick(nickname))
    }

    override suspend fun joinChannel(channel: String) {
        client.sendCommand(IRCCommand.Join(channel))
    }

    override suspend fun leaveChannel(channel: String) {
       client.sendCommand(IRCCommand.Leave(channel))
    }

    override suspend fun sendMessage(channel: String, text: String) {
        client.sendCommand(IRCCommand.Message(channel, text))
    }

    override suspend fun sendPrivateMessage(recipient: String, text: String) {
        client.sendCommand(IRCCommand.PrivateMessage(recipient, text))
    }

    override suspend fun requestChannelList() {
        client.sendCommand(IRCCommand.List)
    }

    override suspend fun requestUsers(channel: String) {
        client.sendCommand(IRCCommand.Users(channel))
    }

    override fun disconnect() {
        client.disconnect()
    }

    override fun clearMessages() {
        client.clearMessages()
    }

    override fun addLocalMessage(message: Message) {
        client.addLocalMessage(message)
    }
}