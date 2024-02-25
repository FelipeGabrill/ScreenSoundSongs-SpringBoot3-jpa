package com.Songs.ScreenSoundSongs.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
	public static String obterInformacoesArtista(String nomeArtista) {
		OpenAiService service = new OpenAiService("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");

		CompletionRequest requisicao = CompletionRequest.builder()
				.model("gpt-3.5-turbo-instruct")
				.prompt("me fale sobre esse cantor: " + nomeArtista)
				.maxTokens(1000)
				.temperature(0.7)
				.build();

		var resposta = service.createCompletion(requisicao);
		return resposta.getChoices().get(0).getText();
	}
}
