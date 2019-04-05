package com.example.seniorsurvey.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.seniorsurvey.R;

import java.util.List;

public class SpinnerGenderAdapter extends BaseAdapter {

    List<String> genderList;
    LayoutInflater layoutInflater;

    public SpinnerGenderAdapter(Activity context, List<String> genderList) {
        this.genderList = genderList;
        layoutInflater=context.getLayoutInflater();
    }

    @Override
    public int getCount() {
        if(genderList==null)
        return 0;
        return genderList.size();
    }

    @Override
    public Object getItem(int position) {
        return genderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_view_gender,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.name=convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= ((ViewHolder) convertView.getTag());
        }
        viewHolder.name.setText(genderList.get(position));

        return convertView;
    }

    class ViewHolder{
        TextView name;
    }
}
