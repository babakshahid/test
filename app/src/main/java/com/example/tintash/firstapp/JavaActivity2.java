package com.example.tintash.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;

public class JavaActivity2 extends BaseClassActivity {

    int count = 0;
    TextView tvHeader, tvRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_java2);
        init();
        setter();
        int randomInt = 0;
        if (count > 0) {
            randomInt = new Random().nextInt(count);
        }

        // Display the random number.
        tvRandom.setText(String.valueOf(randomInt));

        // Substitute the max value into the string resource
        // for the heading, and update the heading
        tvHeader.setText(getString(R.string.header, count));
    }

    private void setter() {
        tvHeader = findViewById(R.id.header);
        tvRandom = findViewById(R.id.random);
    }

    private void init() {
        count = getIntent().getIntExtra(Constants.ACTION.TOTAL_COUNT,0);
    }
}
