package com.example.seniorsurvey.ViewActivity;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.seniorsurvey.API.Model.CourseModel.CourseItem;
import com.example.seniorsurvey.Adapter.CourseListRecyclerAdapter;
import com.example.seniorsurvey.Base.BaseActivity;
import com.example.seniorsurvey.DataHolder;
import com.example.seniorsurvey.R;
import com.example.seniorsurvey.ViewModel.CourseListViewModel;

import java.util.List;


public class CoursesList extends BaseActivity {

    RecyclerView recyclerView;
    CourseListRecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    CourseListViewModel courseListViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_courses_list);
        initView();
        adapter = new CourseListRecyclerAdapter(null);
        layoutManager = new LinearLayoutManager(activity);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        courseListViewModel = ViewModelProviders.of(this).get(CourseListViewModel.class);
        courseListViewModel.getCourseMediatorLiveData().observe(this, new Observer<List<CourseItem>>() {
            @Override
            public void onChanged(@Nullable List<CourseItem> courseItems) {
                if (courseItems==null){
                    //errorMessage if data coming is null
                    showMessage(R.string.error,R.string.no_data,R.string.ok);
                }else {
                    //show data in recyclerView
                    adapter = new CourseListRecyclerAdapter(courseItems);
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemClickListener(new CourseListRecyclerAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int pos, CourseItem course) {

                            Intent intent=new Intent(activity,YoutubeVideoActivity.class);
                            intent.putExtra("youtube_video_key",course.getYoutubeUrl());
                            AddVisitor.selectedCourse=course;
                            DataHolder.course = course;
                            startActivity(intent);

                        }
                    });

                }
            }
        });
        courseListViewModel.getErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String message) {
                if (message!=null){
                    //errorMessage from api if not working
                    showMessage(getString(R.string.error),message ,getString(R.string.ok));
                }
            }
        });

        courseListViewModel.getCourseList(DataHolder.moderator.getId()+"",DataHolder.password);


    }

    private void initView() {
        recyclerView =  findViewById(R.id.courseList);
    }
}
