package com.example.seniorsurvey.API.Model.SumbitAnswer;

import com.google.gson.annotations.SerializedName;

public class AnswerItem {

	@SerializedName("website")
	private String website;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("vendor_id")
	private String vendorId;

	@SerializedName("name")
	private String name;

	@SerializedName("logo")
	private Object logo;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setVendorId(String vendorId){
		this.vendorId = vendorId;
	}

	public String getVendorId(){
		return vendorId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLogo(Object logo){
		this.logo = logo;
	}

	public Object getLogo(){
		return logo;
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

	@Override
 	public String toString(){
		return 
			"AnswerItem{" +
			"website = '" + website + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",vendor_id = '" + vendorId + '\'' + 
			",name = '" + name + '\'' + 
			",logo = '" + logo + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}