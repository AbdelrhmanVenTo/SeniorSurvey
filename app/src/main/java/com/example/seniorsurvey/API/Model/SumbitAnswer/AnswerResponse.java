package com.example.seniorsurvey.API.Model.SumbitAnswer;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AnswerResponse{

	@SerializedName("answerItems")
	private List<AnswerItem> answerItems;

	@SerializedName("status")
	private String status;

	public void setAnswerItems(List<AnswerItem> answerItems){
		this.answerItems = answerItems;
	}

	public List<AnswerItem> getAnswerItems(){
		return answerItems;
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
			"AnswerResponse{" + 
			"answerItems = '" + answerItems + '\'' +
			",status = '" + status + '\'' + 
			"}";
		}
}