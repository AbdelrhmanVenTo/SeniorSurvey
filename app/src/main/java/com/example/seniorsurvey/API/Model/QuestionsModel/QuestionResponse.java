package com.example.seniorsurvey.API.Model.QuestionsModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class QuestionResponse{

	@SerializedName("questionItems")
	private List<QuestionItem> questionItems;

	@SerializedName("status")
	private String status;

	public void setQuestionItems(List<QuestionItem> questionItems){
		this.questionItems = questionItems;
	}

	public List<QuestionItem> getQuestionItems(){
		return questionItems;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"QuestionResponse{" + 
			"questionItems = '" + questionItems + '\'' +
			",status = '" + status + '\'' + 
			"}";
		}
}