package com.example.tintash.firstapp;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JavaActivity1 extends AppCompatActivity implements View.OnClickListener {

    Button toast, count, random;
    TextView count_tv;
    int count_int = 0;
    private static final String TOTAL_COUNT = "total_count";
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_java1);
        init();
        setter();
    }

    private void init() {
        context = getApplicationContext();
    }


    private void setter() {
        count = findViewById(R.id.count);
        random = findViewById(R.id.random);
        toast = findViewById(R.id.toast);
        count_tv = findViewById(R.id.tv_count);

        toast.setOnClickListener(this);
        random.setOnClickListener(this);
        count.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toast:
                showToast("Babak is testing",Toast.LENGTH_SHORT);
                break;
            case R.id.count:
                countInc();
                break;
            case R.id.random:
                startNewActivity();
                break;
            default:
                showToast("No Action is registered",Toast.LENGTH_SHORT);
        }
    }

    private void startNewActivity() {
        Intent newIntent = new Intent(context,JavaActivity2.class);
        newIntent.putExtra(TOTAL_COUNT,count_int);
        startActivity(newIntent);
    }

    private void countInc(){
        count_int++;
        updateUI();
    }

    private void updateUI(){
        count_tv.setText(String.valueOf(count_int));
    }

    private void showToast(String str, int time){
        Toast.makeText(context,str,time).show();
    }

}
