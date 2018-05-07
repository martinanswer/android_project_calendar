package com.example.lenovo.application1;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import static android.graphics.Color.*;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;

    CalendarView calendar;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#a465d7")));
        calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(), dayOfMonth + "/" + (month+1) + "/" + year, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void gotoHome(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void browser(View view) {
        Intent browserIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.google.com.au"));
        startActivity(browserIntent);

    }

    public void gotoevent(View view) {
        Intent intent = new Intent(this, Event.class);
        startActivity(intent);
    }
}


