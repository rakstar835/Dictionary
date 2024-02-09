package vocabvista.rk.dao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class OpenAiApiClient {

	public enum OpenAiService1 {
		DALL_E, GPT_3, GPT_3_TURBO,GPT_4;
	}

	@Value("${openai.api_key}")
	private String openaiApiKey;

	private final HttpClient client = HttpClient.newHttpClient();

	public String postToOpenAiApi(String requestBodyAsJson, OpenAiService1 service) throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder()
				.uri(selectUri(service))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + openaiApiKey)
				.POST(BodyPublishers.ofString(requestBodyAsJson)).build();
		
		return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
	}

	private URI selectUri(OpenAiService1 service) {
		if (service == OpenAiService1.DALL_E) {
			return URI.create("https://api.openai.com/v1/images/generations");
		} else if (service == OpenAiService1.GPT_3) {
			return URI.create("https://api.openai.com/v1/completions");
		}else if (service == OpenAiService1.GPT_4) {
			return URI.create("https://api.openai.com/v1/completions");
		} 
		else if (service == OpenAiService1.GPT_3_TURBO) {
			return URI.create("https://api.openai.com/v1/chat/completions");
		}
		else {
			throw new IllegalArgumentException("Invalid OpenAiService1: " + service);
		}
	}

}
