package vocabvista.rk.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class OptionSingleCorrect {
	private long optionLanguageID;
	private String optionText;
	private String optionImage;	
	private CommonsMultipartFile opsImg;
	
	public CommonsMultipartFile getOpsImg() {
		return opsImg;
	}
	public void setOpsImg(CommonsMultipartFile opsImg) {
		this.opsImg = opsImg;
	}
	public String getOptionText() {
		return optionText;
	}
	public long getOptionLanguageID() {
		return optionLanguageID;
	}
	public void setOptionLanguageID(long optionLanguageID) {
		this.optionLanguageID = optionLanguageID;
	}
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	public String getOptionImage() {
		return optionImage;
	}
	public void setOptionImage(String optionImage) {
		this.optionImage = optionImage;
	}
	
}
