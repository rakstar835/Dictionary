package vocabvista.rk.org.controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import vocabvista.rk.dao.FormInputDTO;
import vocabvista.rk.dao.OpenAiApiClient;
import vocabvista.rk.dao.OpenAiApiClient.OpenAiService1;
import vocabvista.rk.model.EnglishToHindiDictionary;
import vocabvista.rk.model.Message;
import vocabvista.rk.model.RequestChatGPT;
import vocabvista.rk.viewmodel.ChatCompletion;

@Controller
@RequestMapping("dictionary")
public class DictionaryController {

	private static final String HOME_D_PAGE = "dictionary/englishToHindi";

	@Autowired 
	private ObjectMapper jsonMapper;
	@Autowired 
	private OpenAiApiClient client;

	@Value("${openai.model}")
	private String model;

	@Value("${openai.temperature}")
	private double tperature;

	@Value("${openai.max_tokens}")
	private int maxTokens;

	@Value("${openai.frequency_penalty}")
	private int frequencyPenalty;

	@Value("${openai.presence_penalty}")
	private double presencePenalty;
	
	@Value("${openai.top_p}")
	private int top_p;
	
	@GetMapping(path = "/")
	public String index(Model model) {
		model.addAttribute("dto",new FormInputDTO());
		return HOME_D_PAGE;
	}

	@PostMapping(path = "/")
	public String chat(Model model, @ModelAttribute("dto") FormInputDTO dto) {
		try {
			model.addAttribute("request", dto.getPrompt());
			//String response = chatWithGpt3(dto.getPrompt());
			//jsonPatternChecker(response);

			//model.addAttribute("response", response);
		} catch (Exception e) {
			model.addAttribute("response", "Error in communication with OpenAI ChatGPT API.");
			System.out.println("Error : "+e);
		}
		return HOME_D_PAGE;
	}

	private String chatWithGpt3(String message) throws Exception {
		System.out.println(message);
		RequestChatGPT request = new RequestChatGPT();
		Message msg1 = new Message();
		Message msg2 = new Message();
		msg1.setRole("system");
		msg1.setContent("You are a professional Word bank. your job is to generate english to hindi words. and return the response in JSON array represents a word with its associated English word, Hindi translation, English grammar classification (e.g., noun, verb, adjective), and a list of domain categories. here json formate is [{\"english\":\"computer\",\"hindi\":\"कंप्यूटर\",\"grammar\":\"noun\",\"categories\":[\"technology\"]}]");
		
		msg2.setRole("user");
		msg2.setContent("Generate the total 10 words on sport");
		
		request.setModel(model);
		request.setMessages(List.of(msg1,msg2));
		request.setMax_tokens(maxTokens);
		request.setTemperature(tperature);
		request.setFrequency_penalty(frequencyPenalty);
		request.setPresence_penalty(presencePenalty);
		request.setTop_p(top_p);
		
		var postBodyJson = jsonMapper.writeValueAsString(request);
		var responseBody = client.postToOpenAiApi(postBodyJson, OpenAiService1.GPT_3_TURBO);
		var completionResponse = jsonMapper.readValue(responseBody, ChatCompletion.class);
		return completionResponse.getChoices().get(0).getMessage().getContent();
	}


	private String jsonPatternChecker(String response) {

		final String JSON_PATTERN1 = "\\[\\s*\\{\\s*\"english\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"hindi\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"grammar\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"categories\"\\s*:\\s*\\[\\s*\"[^\"]+\"\\s*\\]\\s*\\}\\s*(,\\s*\\{\\s*\"english\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"hindi\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"grammar\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"categories\"\\s*:\\s*\\[\\s*\"[^\"]+\"\\s*\\]\\s*\\})*\\s*\\]";

		ObjectMapper objectMapper = new ObjectMapper();
		String originalResp=response;
		boolean isParsed=false;
		try {
			//Pattern 1
			Pattern pattern1 = Pattern.compile(JSON_PATTERN1,Pattern.DOTALL);
			Matcher matcher1 = pattern1.matcher(response.replaceAll("\\s+", ""));

			/*if (matcher1.matches()) {
				isParsed=true;
				System.out.println("Pattern 1-----------------------------------------");
				QuestionPattern1[] questions = objectMapper.readValue(originalResp, QuestionPattern1[].class);
				for (QuestionPattern1 question : questions) {
					System.out.println("Qus : "+question.getQuestion());
					for (String option : question.getOptions()) {
						System.out.println("opt :: "+option);
					}
					System.out.println("Ans ::"+question.getAnswer());
				}
			}
			 */
			if (matcher1.matches()) {
				objectMapper = new ObjectMapper();

				try {
					List<EnglishToHindiDictionary> englishToHindiDictionarys = objectMapper.readValue(originalResp, new TypeReference<List<EnglishToHindiDictionary>>() {});
					for (EnglishToHindiDictionary englishToHindiDictionary : englishToHindiDictionarys) {
						System.out.println(englishToHindiDictionary.getEnglish());
						System.out.println(englishToHindiDictionary.getHindi());
						System.out.println(englishToHindiDictionary.getGrammar());
						System.out.println(englishToHindiDictionary.getCategories().get(0));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				if(!isParsed) {				
					System.out.println("Invalid JSON pattern : ");
					System.out.println(originalResp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return originalResp;
	}

}
