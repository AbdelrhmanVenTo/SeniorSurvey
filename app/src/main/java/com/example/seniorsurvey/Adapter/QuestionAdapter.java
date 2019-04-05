package com.example.seniorsurvey.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.seniorsurvey.API.Model.QuestionsModel.QuestionItem;
import com.example.seniorsurvey.R;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    List<QuestionItem> questionItems ;

    public QuestionAdapter(List<QuestionItem> questionItems) {
        this.questionItems = questionItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.question_card_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        QuestionItem questionItem = questionItems.get(pos);
        viewHolder.questionContent.setText(questionItem.getName());


    }

    @Override
    public int getItemCount() {
        if (questionItems == null)
            return 0;
        return questionItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView questionContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionContent = itemView.findViewById(R.id.question);


        }
    }
}
