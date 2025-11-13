package com.joaohenrique.ai_linter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ai.model.openai.autoconfigure.OpenAiAudioSpeechAutoConfiguration;
import org.springframework.ai.model.openai.autoconfigure.OpenAiChatAutoConfiguration;
import org.springframework.ai.model.openai.autoconfigure.OpenAiEmbeddingAutoConfiguration;
import org.springframework.ai.model.openai.autoconfigure.OpenAiAudioTranscriptionAutoConfiguration;
import org.springframework.ai.model.openai.autoconfigure.OpenAiImageAutoConfiguration;
import org.springframework.ai.model.openai.autoconfigure.OpenAiModerationAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={
    OpenAiAudioSpeechAutoConfiguration.class,
    OpenAiChatAutoConfiguration.class,
    OpenAiEmbeddingAutoConfiguration.class,
    OpenAiAudioTranscriptionAutoConfiguration.class,
    OpenAiImageAutoConfiguration.class,
    OpenAiModerationAutoConfiguration.class
})
public class AiLinterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiLinterApplication.class, args);
	}

}
