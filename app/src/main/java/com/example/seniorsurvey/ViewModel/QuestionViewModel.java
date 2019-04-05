package com.example.seniorsurvey.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.seniorsurvey.API.APIManager;
import com.example.seniorsurvey.API.Model.QuestionsModel.QuestionItem;
import com.example.seniorsurvey.API.Model.QuestionsModel.QuestionResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionViewModel extends AndroidViewModel {

    MutableLiveData<List<QuestionItem>> questionsList;
    MutableLiveData<String> errorMessage;

    public MutableLiveData<List<QuestionItem>> getQuestionsList() {
        return questionsList;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        questionsList = new MutableLiveData<>();
        errorMessage = new MutableLiveData<>();
    }

    public void getQuestionFromAPI(String moderator_id, String password, String entity_id){
        APIManager.getApis().getQuestion(moderator_id, password, entity_id)
                .enqueue(new Callback<QuestionResponse>() {
                    @Override
                    public void onResponse(Call<QuestionResponse> call, Response<QuestionResponse> response) {
                        if (response.isSuccessful()){
                            if ("success".equals(response.body().getStatus())){
                                questionsList.postValue(response.body().getQuestionItems());
                            }else
                                errorMessage.postValue("Error No Data");
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionResponse> call, Throwable t) {
                        errorMessage.postValue(t.getLocalizedMessage());
                    }
                });
    }


    public void submitQuestion (){

    }
}
