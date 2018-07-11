package com.example.tintash.firstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

public class LifeCycleTest extends BaseClassActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_nextpage);
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
    }

    @Override
    protected void onRestart() {
        Log.d("LifeCycle","Restart");
        super.onRestart();
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
        Log.d("LifeCycle","Destroyed");
        super.onDestroy();
    }
}
