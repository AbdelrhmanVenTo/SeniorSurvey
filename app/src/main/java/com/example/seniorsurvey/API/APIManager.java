package com.example.seniorsurvey.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {

    private static Retrofit retrofitInstance;

   private  static Retrofit getInstance(){
        if(retrofitInstance==null){
            retrofitInstance=new Retrofit.Builder()
                    .baseUrl("http://stdattendance.com/survey/public/api/moderator/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }


    public static APICalls getApis(){
       APICalls APIS=getInstance().create(APICalls.class);
       return APIS;
    }
}
