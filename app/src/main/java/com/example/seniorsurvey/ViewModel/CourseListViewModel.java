package com.example.seniorsurvey.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.seniorsurvey.API.APIManager;
import com.example.seniorsurvey.API.Model.CourseModel.CourseItem;
import com.example.seniorsurvey.API.Model.CourseModel.CoursesResponse;
import com.example.seniorsurvey.DataHolder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseListViewModel extends AndroidViewModel {

    MutableLiveData<List<CourseItem>> courseMediatorLiveData;
    MutableLiveData<String> errorMessage;

    public CourseListViewModel(@NonNull Application application) {
        super(application);
        courseMediatorLiveData = new MutableLiveData<>();
        errorMessage=new MutableLiveData<>();
    }

    public MutableLiveData<List<CourseItem>> getCourseMediatorLiveData() {
        return courseMediatorLiveData;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void getCourseList(String moderator , String password){
        APIManager.getApis()
                .getAuthorizedEntities(moderator, password).enqueue(new Callback<CoursesResponse>() {
            @Override
            public void onResponse(Call<CoursesResponse> call, Response<CoursesResponse> response) {
                if (response.isSuccessful()){
                    if ("success".equals(response.body().getStatus())){
                        courseMediatorLiveData.postValue(response.body().getcourseItems());
                    }else
                        errorMessage.postValue("Error No Data");

                }
            }

            @Override
            public void onFailure(Call<CoursesResponse> call, Throwable t) {
                errorMessage.postValue(t.getLocalizedMessage());
            }
        });

    }
}
