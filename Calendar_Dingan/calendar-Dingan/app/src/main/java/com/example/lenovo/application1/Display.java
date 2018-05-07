package com.example.lenovo.application1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {
    TextView myTextView;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        myTextView = (TextView) findViewById(R.id.textView2);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#BDB76B")));

        Intent myIntent = getIntent();
        Float rating = myIntent.getFloatExtra("rating", -1);
        if (rating == -1) {
            myTextView.setText("Error:404");
        }
        myTextView.setText(rating.toString());
    }
}