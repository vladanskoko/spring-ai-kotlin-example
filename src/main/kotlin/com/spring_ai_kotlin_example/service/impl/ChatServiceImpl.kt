package com.spring_ai_kotlin_example.service.impl

import com.spring_ai_kotlin_example.service.ChatService
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.stereotype.Service

@Service
class ChatServiceImpl(private val chatClient: ChatClient.Builder) : ChatService {

    override fun generateResponse(query: String): String {
        return chatClient.build()
            .prompt()
            .user(query)
            .call()
            .content()
    }

    override fun generateJsonResponse(query: String): ChatResponse {
        return chatClient.build()
            .prompt()
            .user(query)
            .call()
            .chatResponse()
    }

    override fun getSongsByArtist(artist: String): String {
        val query = """
                Please give me a list of top 10 songs for the artist {artist}. If you don't know the answer, just say.
                """.trimIndent()
        val promptTemplate = PromptTemplate(query, mutableMapOf(Pair<String, Any>("artist", artist)))
        val prompt = promptTemplate.create()

        val chatResponse = chatClient.build()
            .prompt(prompt)
            .call()
            .chatResponse()

        return chatResponse
            .result
            .output
            .content
    }

}
