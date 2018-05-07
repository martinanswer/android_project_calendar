package com.example.lenovo.application1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.R.attr.rating;
import static com.example.lenovo.application1.R.id.ratingBar;

public class Note extends AppCompatActivity implements View.OnClickListener {
    RatingBar myRatingBar;
    TextView myText;
    SeekBar mySeekBar;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#BDB76B")));
        myRatingBar = (RatingBar) findViewById(ratingBar);
        myText = (TextView) findViewById(R.id.textViewValue);
        mySeekBar = (SeekBar) findViewById(R.id.seekBar);
        myRatingBar.setMax(5);
        myRatingBar.setStepSize(1);
        mySeekBar.setMax(myRatingBar.getMax());
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){
                if (fromUser){
                    myRatingBar.setRating(progress);
                    myText.setText(String.valueOf(myRatingBar.getRating()));
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
                myText.setText(String.valueOf(myRatingBar.getRating()));
            }

        });
        myRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mySeekBar.setProgress(ratingBar.getProgress());
                if (fromUser) {
                    myText.setText(String.valueOf(rating));

                }

            }
        });
        Button saveButton = (Button)findViewById(R.id.button_save);
        Button viewButton = (Button)findViewById(R.id.button_view);

        saveButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_save){

            String name = myText.getText().toString();

            SharedPreferences sharedPreferences = getSharedPreferences("prefs",MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("myname",name);

            editor.commit();

        } else{

            startActivity(new Intent(getApplicationContext(), NoteDisplay.class));

        }
    }
}