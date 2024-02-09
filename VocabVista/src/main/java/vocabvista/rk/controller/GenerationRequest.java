package vocabvista.rk.controller;

public class GenerationRequest {
    private String prompt;
    private int n;
    private String size;
    private String response_format;

    public GenerationRequest(String prompt, int n, String size, String response_format) {
        this.prompt = prompt;
        this.n = n;
        this.size = size;
        this.response_format = response_format;
    }

    public static GenerationRequest defaultWith(String prompt) {
        return new GenerationRequest(prompt, 1, "1024x1024", "url");
    }

    public String getPrompt() {
        return prompt;
    }

    public int getN() {
        return n;
    }

    public String getSize() {
        return size;
    }

    public String getResponseFormat() {
        return response_format;
    }
}
