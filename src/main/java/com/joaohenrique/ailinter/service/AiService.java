package com.joaohenrique.ailinter.service;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class AiService {

    private final ChatModel chatModel;

    @Autowired
    public AiService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public AssistantMessage analyzeCode(String code) {
        String message = """
                Analyze the following Java code and provide feedback on clean code, SOLID principles, and design patterns.
                The code is:
                {code}
                """;

        PromptTemplate promptTemplate = new PromptTemplate(message);
        Prompt prompt = promptTemplate.create(Map.of("code", code));

        return chatModel
                .call(prompt)
                .getResult()
                .getOutput();
    }
}
