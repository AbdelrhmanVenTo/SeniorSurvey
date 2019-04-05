package com.example.seniorsurvey.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.seniorsurvey.API.APIManager;
import com.example.seniorsurvey.API.Model.LoginModel.LoginResponse;
import com.example.seniorsurvey.API.Model.LoginModel.Moderator;
import com.example.seniorsurvey.API.Model.VisitorRegistrationResponse.RegistrationResponse;
import com.example.seniorsurvey.API.Model.VisitorRegistrationResponse.Visitor;
import com.example.seniorsurvey.DataHolder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {

    MutableLiveData<Moderator> moderatorLiveData;
    MutableLiveData<Visitor> visitor;
    MutableLiveData<String> errorMessage;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        moderatorLiveData=new MutableLiveData<>();
        errorMessage=new MutableLiveData<>();
        visitor=new MutableLiveData<>();
    }

    public MutableLiveData<Moderator> getModeratorLiveData() {
        return moderatorLiveData;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public MutableLiveData<Visitor> getVisitor() {
        return visitor;
    }


    public void login(String sUsername, String sPassword) {
        APIManager.getApis()
                .login(sUsername,sPassword)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call,
                                           Response<LoginResponse> response) {
                        if(response.isSuccessful()){
                            if("success".equals(response.body().getStatus())){
                                moderatorLiveData.postValue(response.body().getmoderator());
                                DataHolder.moderator = response.body().getmoderator();
                            }else
                                moderatorLiveData.postValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call,
                                          Throwable t) {
                        errorMessage.postValue(t.getLocalizedMessage());
                    }
                });
    }

    public void RegisterVisitor(String name,String phone,String gender,String courseId) {
        APIManager.getApis()
                .AddVisitor(DataHolder.moderator.getId() + "",
                        DataHolder.password,
                        name,
                        phone,
                        courseId,
                        gender).enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call,
                                   Response<RegistrationResponse> response) {
                if (response.isSuccessful()) {
                    if ("success".equals(response.body().getStatus())) {
                        visitor.postValue(response.body().getvisitor());
                        return;
                    }
                }
                visitor.postValue(null);
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                errorMessage.setValue(t.getLocalizedMessage());
            }
        });

    }
    }
