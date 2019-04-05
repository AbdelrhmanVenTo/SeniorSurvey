package com.example.seniorsurvey.API.Model.QuestionsModel;

import com.google.gson.annotations.SerializedName;

public class QuestionItem {

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("category_id")
	private String categoryId;

	@SerializedName("name")
	private String name;

	@SerializedName("answer3")
	private String answer3;

	@SerializedName("answer2")
	private String answer2;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("answer4")
	private String answer4;

	@SerializedName("entity_id")
	private String entityId;

	@SerializedName("answer1")
	private String answer1;

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAnswer3(String answer3){
		this.answer3 = answer3;
	}

	public String getAnswer3(){
		return answer3;
	}

	public void setAnswer2(String answer2){
		this.answer2 = answer2;
	}

	public String getAnswer2(){
		return answer2;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAnswer4(String answer4){
		this.answer4 = answer4;
	}

	public String getAnswer4(){
		return answer4;
	}

	public void setEntityId(String entityId){
		this.entityId = entityId;
	}

	public String getEntityId(){
		return entityId;
	}

	public void setAnswer1(String answer1){
		this.answer1 = answer1;
	}

	public String getAnswer1(){
		return answer1;
	}

	@Override
 	public String toString(){
		return 
			"QuestionItem{" +
			"updated_at = '" + updatedAt + '\'' + 
			",category_id = '" + categoryId + '\'' + 
			",name = '" + name + '\'' + 
			",answer3 = '" + answer3 + '\'' + 
			",answer2 = '" + answer2 + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",answer4 = '" + answer4 + '\'' + 
			",entity_id = '" + entityId + '\'' + 
			",answer1 = '" + answer1 + '\'' + 
			"}";
		}
}