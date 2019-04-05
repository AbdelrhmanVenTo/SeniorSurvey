package com.example.seniorsurvey.API.Model.LoginModel;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("data")
	private Moderator moderator;

	@SerializedName("status")
	private String status;

	public void setmoderator(Moderator moderator){
		this.moderator = moderator;
	}

	public Moderator getmoderator(){
		return moderator;
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
			"LoginResponse{" + 
			"data = '" + moderator + '\'' +
			",status = '" + status + '\'' + 
			"}";
		}
}