package com.example.seniorsurvey.ViewActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;

import android.view.View;
import android.widget.Button;

import com.example.seniorsurvey.API.Model.LoginModel.Moderator;
import com.example.seniorsurvey.Base.BaseActivity;
import com.example.seniorsurvey.DataHolder;
import com.example.seniorsurvey.R;
import com.example.seniorsurvey.ViewModel.LoginViewModel;


public class Login extends BaseActivity implements View.OnClickListener {

    protected TextInputLayout email;
    protected TextInputLayout password;
    protected Button login;
    LoginViewModel viewModel;

    protected String sUserName;
    protected String sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_login);
        initView();
        //initialize view model object
        viewModel= ViewModelProviders.of(this)
                .get(LoginViewModel.class);
        viewModel.getErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String message) {
                hideProgressBar();
                showMessage(getString(R.string.error),message,getString(R.string.ok));
            }
        });
        viewModel.getModeratorLiveData()
                .observe(this, new Observer<Moderator>() {
                    @Override
                    public void onChanged(@Nullable Moderator moderator) {
                        hideProgressBar();
                        if(moderator==null){
                            showMessage(R.string.error,R.string.user_name_or_password_not_valid,R.string.ok);
                        }else {
                            DataHolder.password=password.getEditText().getText().toString();
                            DataHolder.moderator=moderator;
                            //start activity home
                            Intent intent = new Intent(activity,CoursesList.class);
                            startActivity(intent);


                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {

            sUserName = email.getEditText().getText().toString();
            if (sUserName.trim().equals("")) {
                email.setError(getString(R.string.required));
                return;

            }
            email.setError(null);
            sPassword = password.getEditText().getText().toString();
            if (sPassword.trim().equals("")) {
                password.setError(getString(R.string.required));
                return;

            } else if (sPassword.length() < 5) {
                password.setError(getString(R.string.min_6_chars));
                return;

            }
            password.setError(null);

            showProgressBar(R.string.please_wait, R.string.loading);
            viewModel.login(sUserName,sPassword);

        }
    }



    private void initView() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(Login.this);
    }
}
