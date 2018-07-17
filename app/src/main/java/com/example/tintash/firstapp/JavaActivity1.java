package com.example.tintash.firstapp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JavaActivity1 extends BaseClassActivity implements View.OnClickListener{

    Button toast, count, random;
    TextView tvCount;
    int countInt = 0;
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
        tvCount = findViewById(R.id.tv_count);

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
                showToast("No Action is registered", Toast.LENGTH_SHORT);
        }
    }

    private void startNewActivity() {
        Intent newIntent = new Intent(context, JavaActivity2.class);
        newIntent.putExtra(Constants.ACTION.TOTAL_COUNT, countInt);
        startActivity(newIntent);
    }

    private void countInc(){
        countInt++;
        updateUI();
    }

    private void updateUI(){
        tvCount.setText(String.valueOf(countInt));
    }

    private void showToast(String str, int time){
        Toast.makeText(context,str,time).show();
    }

}
