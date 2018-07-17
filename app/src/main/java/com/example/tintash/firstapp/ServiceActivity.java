package com.example.tintash.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ServiceActivity extends BaseClassActivity implements View.OnClickListener {

    Button btnStart, btnStop, btnNext, btnForStart, btnForStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
        setter();
    }

    protected void setter() {
        btnStart = findViewById(R.id.btn_start);
        btnNext = findViewById(R.id.btn_next);
        btnStop = findViewById(R.id.btn_stop);
        btnForStart = findViewById(R.id.btn_for_start);
        btnForStop = findViewById(R.id.btn_for_stop);

        btnNext.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnForStop.setOnClickListener(this);
        btnForStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("Check101", String.valueOf(v.getId()));
        Log.d("Check101", String.valueOf(R.id.btn_for_start));
        switch (v.getId()) {
            case R.id.btn_start:
                startService(new Intent(this,
                        com.example.tintash.firstapp.ExampleService.class));
                break;
            case R.id.btn_stop:
                stopService(new Intent(this,
                        com.example.tintash.firstapp.ExampleService.class));
                break;
            case R.id.btn_next:
                startActivity(new Intent(this, LifeCycleTest.class));
                break;
            case R.id.btn_for_start:
                startService(new Intent(this,
                        com.example.tintash.firstapp.ExampleForegroundService.class).setAction(
                        Constants.ACTION.STARTFOREGROUND_ACTION));
                break;
            case R.id.btn_for_stop:
                stopService(new Intent(this,
                        com.example.tintash.firstapp.ExampleForegroundService.class).setAction(
                        Constants.ACTION.STOPFOREGROUND_ACTION));
                break;
            default:
                Toast toast = Toast.makeText(this,
                        "Nothing is registered", Toast.LENGTH_SHORT);
                toast.show();
        }

    }
}
