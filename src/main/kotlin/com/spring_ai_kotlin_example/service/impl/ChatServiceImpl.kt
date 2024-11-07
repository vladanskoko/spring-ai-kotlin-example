package com.spring_ai_kotlin_example.service.impl

import com.spring_ai_kotlin_example.service.ChatService
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.stereotype.Service

@Service
class ChatServiceImpl(private val chatClient: ChatClient.Builder) : ChatService {

    override fun generateResponse(query: String): String {
        return chatClient.build()
            .prompt(query)
            .call()
            .content()
    }

    override fun generateJsonResponse(query: String): ChatResponse {
        return chatClient.build()
            .prompt(query)
            .call()
            .chatResponse()
    }

}
