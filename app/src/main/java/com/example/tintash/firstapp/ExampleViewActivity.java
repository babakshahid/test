package com.example.tintash.firstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ExampleViewActivity extends BaseClassActivity {

    RecyclerView recyclerView;
    ArrayList<String> animals;
    ArrayList<String> description;
    RecyclerViewAdaptor myRecyclerAdaptor;
    ListView listView;
    ListViewAdaptor myListviewAdaptor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
        init();
        run();
    }

    private void init(){
        recyclerView = findViewById( R.id.RecyclerView );

        animals = new ArrayList<>( Arrays.asList(
                getResources().getStringArray(R.array.animals)));

        description = new ArrayList<>( Arrays.asList(
                getResources().getStringArray(R.array.animal_Description)));
        myRecyclerAdaptor = new RecyclerViewAdaptor(this, animals,description);
        listView = findViewById(R.id.listView);
        myListviewAdaptor= new ListViewAdaptor(this,animals,description);
    }

    public void run(){
        recyclerView.setAdapter(myRecyclerAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(myListviewAdaptor);

    }

}
