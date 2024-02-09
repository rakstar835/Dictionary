package vocabvista.rk.model;

import java.util.List;

public class EnglishToHindiDictionary {
	private long EnglishToHindiDictionaryID;
    private String english;
    private String hindi;
    private String grammar;
    private List<String> categories;
    
	public long getEnglishToHindiDictionaryID() {
		return EnglishToHindiDictionaryID;
	}
	public void setEnglishToHindiDictionaryID(long englishToHindiDictionaryID) {
		EnglishToHindiDictionaryID = englishToHindiDictionaryID;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getHindi() {
		return hindi;
	}
	public void setHindi(String hindi) {
		this.hindi = hindi;
	}
	public String getGrammar() {
		return grammar;
	}
	public void setGrammar(String grammar) {
		this.grammar = grammar;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}


}
