package com.example.lenovo.application1;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NoteDisplay extends AppCompatActivity {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_display);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#BDB76B")));
        SharedPreferences sharedPreferences = getSharedPreferences("prefs",MODE_PRIVATE);

        String name = sharedPreferences.getString("myname","aaaa");

        TextView textView = (TextView)findViewById(R.id.textView_display);

        textView.setText(name);
    }
}
