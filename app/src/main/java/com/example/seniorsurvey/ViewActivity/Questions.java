package com.example.seniorsurvey.ViewActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.seniorsurvey.API.Model.QuestionsModel.QuestionItem;
import com.example.seniorsurvey.Adapter.QuestionAdapter;
import com.example.seniorsurvey.Base.BaseActivity;
import com.example.seniorsurvey.DataHolder;
import com.example.seniorsurvey.R;
import com.example.seniorsurvey.ViewModel.QuestionViewModel;

import java.util.List;

public class Questions extends BaseActivity implements View.OnClickListener {

    protected RecyclerView questionRecyclerView;
    protected Button submit;
    QuestionAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    QuestionViewModel questionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_questions);
        initView();
        layoutManager = new LinearLayoutManager(activity);
        adapter = new QuestionAdapter(null);
        questionRecyclerView.setAdapter(adapter);
        questionRecyclerView.setLayoutManager(layoutManager);
        questionViewModel = ViewModelProviders.of(this).get(QuestionViewModel.class);
        questionViewModel.getErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String message) {
                hideProgressBar();
                showMessage(getString(R.string.error), message, getString(R.string.ok));
            }
        });

        questionViewModel.getQuestionsList().observe(this, new Observer<List<QuestionItem>>() {
            @Override
            public void onChanged(@Nullable List<QuestionItem> questionItems) {
                if (questionItems == null) {
                    //errorMessage if data coming is null
                    showMessage(R.string.error, R.string.no_data, R.string.ok);
                } else {
                    //show data in recycler
                    adapter = new QuestionAdapter(questionItems);
                    questionRecyclerView.setAdapter(adapter);
                }
            }
        });


        questionViewModel.getQuestionFromAPI(DataHolder.moderator.getId() + "", DataHolder.password, DataHolder.course.getId() + "");
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submit) {

        }
    }


    private void initView() {
        questionRecyclerView = (RecyclerView) findViewById(R.id.questionRecyclerView);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(Questions.this);
    }
}
