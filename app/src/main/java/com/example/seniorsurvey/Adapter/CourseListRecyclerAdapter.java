package com.example.seniorsurvey.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seniorsurvey.API.Model.CourseModel.CourseItem;
import com.example.seniorsurvey.R;

import java.util.List;

public class CourseListRecyclerAdapter extends RecyclerView.Adapter<CourseListRecyclerAdapter.ViewHolder> {
    List<CourseItem> coursesList;

    public CourseListRecyclerAdapter(List<CourseItem> courseItems) {
        this.coursesList = courseItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_item_course_list ,viewGroup ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int pos) {
        final CourseItem courseItem = coursesList.get(pos);
        viewHolder.courseName.setText(courseItem.getName());
        viewHolder.courseDsc.setText(courseItem.getDescription());
        if(onItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(pos,courseItem);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (coursesList == null)
            return 0;
        return coursesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView courseName , courseDsc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.courseName);
            courseDsc = itemView.findViewById(R.id.courseDsc);

        }
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos,CourseItem course);
    }

}
