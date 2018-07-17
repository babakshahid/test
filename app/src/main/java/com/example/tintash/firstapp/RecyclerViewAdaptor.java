package com.example.tintash.firstapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.myHolder>{

    Context context;
    ArrayList<String> header_Data;
    ArrayList<String> description_Data;
    int count;

    public RecyclerViewAdaptor(Context ct, ArrayList<String> s1, ArrayList<String> s2){
        context = ct;
        header_Data = s1;
        description_Data=s2;
        count = 0;
    }


    @NonNull
    @Override
    public RecyclerViewAdaptor.myHolder onCreateViewHolder(@NonNull android.view.ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(context).inflate(
                R.layout.list_row, parent,false);
        Log.d("Recycler View onCreate",count + "");
        count++;
        return new myHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdaptor.myHolder holder, int position) {
        holder.header.setText(header_Data.get(position));
        holder.description.setText(description_Data.get(position));
    }

    @Override
    public int getItemCount() {
        return header_Data.size();
    }

    public class myHolder extends RecyclerView.ViewHolder{
        TextView header;
        TextView description;

        public myHolder(android.view.View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.header);
            description = itemView.findViewById(R.id.description);
        }
    }
}
