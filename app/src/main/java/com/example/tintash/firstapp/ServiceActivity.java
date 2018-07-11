package com.example.tintash.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ServiceActivity extends BaseClassActivity implements View.OnClickListener {

    Button btnStart, btnStop,btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
        setter();
    }

    protected void setter(){
        btnStart = findViewById(R.id.btn_start);
        btnNext = findViewById(R.id.btn_next);
        btnStop = findViewById(R.id.btn_stop);

        btnNext.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                startService(new Intent(this, com.example.tintash.firstapp.ExampleService.class));
                break;
            case R.id.btn_stop:
                stopService(new Intent(this, com.example.tintash.firstapp.ExampleService.class));
                break;
            case R.id.btn_next:
                startActivity(new Intent(this,LifeCycleTest.class));
                break;
            default:
                Toast toast = Toast.makeText(this,"Nothing is registered",Toast.LENGTH_SHORT);
                toast.show();
        }

    }
}
