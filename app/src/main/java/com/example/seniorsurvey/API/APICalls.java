package com.example.seniorsurvey.API;


import com.example.seniorsurvey.API.Model.CourseModel.CoursesResponse;
import com.example.seniorsurvey.API.Model.LoginModel.LoginResponse;
import com.example.seniorsurvey.API.Model.QuestionsModel.QuestionResponse;
import com.example.seniorsurvey.API.Model.SumbitAnswer.AnswerResponse;
import com.example.seniorsurvey.API.Model.VisitorRegistrationResponse.RegistrationResponse;


import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APICalls {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse>
    login(@Field("user_name") String userName, @Field("password")String password);

    @FormUrlEncoded
    @POST("entities")
    Call<CoursesResponse> getAuthorizedEntities(@Field("moderator_id") String moderator,
                                                @Field("password") String password);


    @FormUrlEncoded
    @POST("visitors/create")
    Call<RegistrationResponse>AddVisitor(@Field("moderator_id") String moderator_id,
                                         @Field("password") String password,
                                         @Field("visitor_name") String visitor_name,
                                         @Field("visitor_mobile") String visitor_mobile,
                                         @Field("entity_id") String entity_id,
                                         @Field("visitor_gender") String visitor_gender);

    @FormUrlEncoded
    @POST("survey/questions")
    Call<QuestionResponse>getQuestion(@Field("moderator_id") String moderator_id,
                                      @Field("password") String password,
                                      @Field("entity_id") String entity_id);


    @FormUrlEncoded
    @POST("survey/add")
    Call<AnswerResponse>submitAnswer(@Field("moderator_id") String moderator_id,
                                       @Field("password") String password,
                                       @Field("visitor_name") String visitor_name,
                                       @Field("visitor_mobile") String visitor_mobile,
                                       @Field("entity_id") String entity_id,
                                       @Field("visitor_gender") String visitor_gender);


}
