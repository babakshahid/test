package com.example.tintash.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;

public class JavaActivity2 extends AppCompatActivity {

    private static final String TOTAL_COUNT = "total_count";
    int count = 0;
    TextView Header_tv, Random_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_java2);
        init();
        setter();
        int randomInt = 0;
        if (count>0) {
            randomInt = new Random().nextInt(count);
        }

        // Display the random number.
        Random_tv.setText(Integer.toString(randomInt));

        // Substitute the max value into the string resource
        // for the heading, and update the heading
        Header_tv.setText(getString(R.string.header, count));
    }

    private void setter() {
        Header_tv = findViewById(R.id.header);
        Random_tv = findViewById(R.id.random);
    }

    private void init() {
        count = getIntent().getIntExtra(TOTAL_COUNT,0);
    }
}
