package com.example.tintash.firstapp;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdaptor extends BaseAdapter {
    Context context;
    ArrayList<String> header_Data;
    ArrayList<String> description_Data;
    int count;
    int count2;
    static class myViewHolder{
        TextView header;
        TextView description;
    }

    public ListViewAdaptor(Context ct, ArrayList<String> s1,ArrayList<String> s2 ){
        context = ct;
        header_Data = s1;
        description_Data=s2;
        count=count2=0;
    }

    @Override
    public int getCount() {
        return header_Data.size();
    }

    @Override
    public Object getItem(int position) {
        return header_Data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        myViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_row,null);
            viewHolder = new myViewHolder();
            viewHolder.header = convertView.findViewById(R.id.header);
            viewHolder.description = convertView.findViewById(R.id.description);
            convertView.setTag(viewHolder);
            Log.d("GetView, if",count+"");
            count++;
        }else{
            viewHolder = (myViewHolder) convertView.getTag();
            Log.d("GetView, else",count2+"");
            count2++;
        }
        viewHolder.header.setText(header_Data.get(position));
        viewHolder.description.setText(description_Data.get(position));
        return convertView;
    }
}
