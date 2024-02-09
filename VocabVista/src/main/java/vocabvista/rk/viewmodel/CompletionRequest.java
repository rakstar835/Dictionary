package vocabvista.rk.viewmodel;

import org.springframework.stereotype.Component;

@Component
public class CompletionRequest {

    private  String model;
    private  String prompt;
    private  double temperature;
    private  int max_tokens; 
    private  int frequency_penalty;
    private  int presence_penalty;
    
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public int getMax_tokens() {
		return max_tokens;
	}
	public void setMax_tokens(int max_tokens) {
		this.max_tokens = max_tokens;
	}
	public int getFrequency_penalty() {
		return frequency_penalty;
	}
	public void setFrequency_penalty(int frequency_penalty) {
		this.frequency_penalty = frequency_penalty;
	}
	public int getPresence_penalty() {
		return presence_penalty;
	}
	public void setPresence_penalty(int presence_penalty) {
		this.presence_penalty = presence_penalty;
	}
    
    

}