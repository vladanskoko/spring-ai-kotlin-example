package com.spring_ai_kotlin_example.service

import org.springframework.ai.chat.model.ChatResponse

interface ChatService {

    fun generateResponse(query: String): String
    fun generateJsonResponse(query: String): ChatResponse
    fun getSongsByArtist(artist: String): String

}
