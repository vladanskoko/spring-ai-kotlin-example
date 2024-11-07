package com.spring_ai_rest_api_example.service

import org.springframework.ai.chat.model.ChatResponse

interface ChatService {

    fun generateResponse(query: String): String
    fun generateJsonResponse(query: String): ChatResponse

}
