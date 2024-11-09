package com.spring_ai_kotlin_example.controller

import com.spring_ai_kotlin_example.service.ChatService
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/chat")
class ChatController(private val chatService: ChatService) {

    @GetMapping("/generate")
    fun generateResponse(@RequestParam(defaultValue = "write greetings message") query: String): String {
        return chatService.generateResponse(query)
    }

    @GetMapping("/generate-json")
    fun generateJsonResponse(@RequestParam(defaultValue = "write greetings message") query: String): ChatResponse {
        return chatService.generateJsonResponse(query)
    }

    @GetMapping("/songs")
    fun getSongsByArtist(@RequestParam(defaultValue = "Michael Jackson") artist: String): String {
        return chatService.getSongsByArtist(artist)
    }

}
