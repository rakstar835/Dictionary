package vocabvista.rk.model;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MultipleChoiceSingleCorrect{
	private long fkItemLanguageID;
	private String itemText;
	private String itemImage;	
		
	private List<OptionSingleCorrect> optionList;
	private CommonsMultipartFile quesImg;
	
	public CommonsMultipartFile getQuesImg() {
		return quesImg;
	}
	public void setQuesImg(CommonsMultipartFile quesImg) {
		this.quesImg = quesImg;
	}
	public List<OptionSingleCorrect> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<OptionSingleCorrect> optionList) {
		this.optionList = optionList;
	}
	public String getItemText() {
		return itemText;
	}
	public long getFkItemLanguageID() {
		return fkItemLanguageID;
	}
	public void setFkItemLanguageID(long fkItemLanguageID) {
		this.fkItemLanguageID = fkItemLanguageID;
	}
	public void setItemText(String itemText) {
		this.itemText = itemText;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

}
