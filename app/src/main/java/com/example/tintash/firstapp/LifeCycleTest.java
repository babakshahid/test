package com.example.tintash.firstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class LifeCycleTest extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LifeCycle", "Created");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","Stopped");
    }

    @Override
    protected void onDestroy() {
        Log.d("LifeCycle", "Destroyed");
        super.onDestroy();
    }
}
