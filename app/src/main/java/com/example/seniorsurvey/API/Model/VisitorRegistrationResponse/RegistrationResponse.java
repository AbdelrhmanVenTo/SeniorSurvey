package com.example.seniorsurvey.API.Model.VisitorRegistrationResponse;

import com.google.gson.annotations.SerializedName;

public class RegistrationResponse{

	@SerializedName("data")
	private Visitor visitor;

	@SerializedName("status")
	private String status;

	public void setvisitor(Visitor data){
		this.visitor = data;
	}

	public Visitor getvisitor(){
		return visitor;
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
			"RegistrationResponse{" + 
			"data = '" + visitor + '\'' +
			",status = '" + status + '\'' + 
			"}";
		}
}