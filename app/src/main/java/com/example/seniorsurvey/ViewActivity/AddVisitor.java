package com.example.seniorsurvey.ViewActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.seniorsurvey.API.Model.CourseModel.CourseItem;
import com.example.seniorsurvey.API.Model.VisitorRegistrationResponse.Visitor;
import com.example.seniorsurvey.Adapter.SpinnerGenderAdapter;
import com.example.seniorsurvey.Base.BaseActivity;
import com.example.seniorsurvey.R;
import com.example.seniorsurvey.ViewModel.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddVisitor extends BaseActivity implements View.OnClickListener {


    protected TextInputLayout username;
    protected TextInputLayout phone;

    protected Spinner gender;
    protected Button next;
    SpinnerGenderAdapter adapter;
    List<String> genderList;
    LoginViewModel viewModel;
    static CourseItem selectedCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_add_visitor);
        initView();
        viewModel= ViewModelProviders.of(this).get(LoginViewModel.class);
        genderList=new ArrayList<>();
        genderList.add(getString(R.string.male));
        genderList.add(getString(R.string.female));
        adapter=new SpinnerGenderAdapter(activity,genderList);
        gender.setAdapter(adapter);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(activity, genderList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        viewModel.getErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String message) {
                showMessage(getString(R.string.fail),message,getString(R.string.ok));
            }
        });
        viewModel.getVisitor().observe(this, new Observer<Visitor>() {
            @Override
            public void onChanged(@Nullable Visitor visitor) {
                if(visitor==null){
                    showMessage(R.string.fail,R.string.failed_to_add_visitor,R.string.ok);
                }else {
                    showMessage(R.string.success,R.string.visior_added,R.string.ok);
                    //Start Question activity
                }
            }
        });


    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next) {
            String name=username.getEditText().getText().toString();
            String mobile=phone.getEditText().getText().toString();
            String genderString= ((String) gender.getSelectedItem());
            viewModel.RegisterVisitor(name,mobile,genderString,selectedCourse.getId()+"");

        }
    }

    private void initView() {
        username = (TextInputLayout) findViewById(R.id.username);
        phone = (TextInputLayout) findViewById(R.id.phone);
        gender = (Spinner) findViewById(R.id.gender);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(AddVisitor.this);
    }
}
