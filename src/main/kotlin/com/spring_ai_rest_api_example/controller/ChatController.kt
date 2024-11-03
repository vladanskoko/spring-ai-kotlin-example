package com.spring_ai_rest_api_example.controller

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/chat")
class ChatController(private val chatClientBuilder: ChatClient.Builder) {

    @GetMapping("/generate")
    fun generateResponse(@RequestParam(defaultValue = "write greetings message") message: String): String {
        return chatClientBuilder.build()
            .prompt(message)
            .call()
            .content()
    }

    @GetMapping("/generate-json")
    fun generateJsonResponse(@RequestParam(defaultValue = "write greetings message") message: String): ChatResponse {
        return chatClientBuilder.build()
            .prompt(message)
            .call()
            .chatResponse()
    }

}