package com.example.seniorsurvey.API.Model.CourseModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CoursesResponse{

	@SerializedName("data")
	private List<CourseItem> courseItems;

	@SerializedName("status")
	private String status;

	public void setcourseItems(List<CourseItem> courseItems){
		this.courseItems = courseItems;
	}

	public List<CourseItem> getcourseItems(){
		return courseItems;
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
			"CoursesResponse{" + 
			"data = '" + courseItems + '\'' +
			",status = '" + status + '\'' + 
			"}";
		}
}