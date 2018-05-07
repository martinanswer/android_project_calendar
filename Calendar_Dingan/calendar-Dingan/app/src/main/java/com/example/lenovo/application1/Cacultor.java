package com.example.lenovo.application1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cacultor extends AppCompatActivity {
    ActionBar actionBar;
    EditText txtFirstValue;
    EditText txtSecondValue;
    EditText txtResultValue;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cacultor);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#BDB76B")));
        txtFirstValue = (EditText) findViewById(R.id.editText1);
        txtSecondValue = (EditText) findViewById(R.id.editText2);
        txtResultValue = (EditText) findViewById(R.id.editText3);
        btnCalculate = (Button) findViewById(R.id.button);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int first = Integer.parseInt(txtFirstValue.getText().toString());
                final int second = Integer.parseInt(txtSecondValue.getText().toString());
                final Integer result = first + second;
                txtResultValue.setText(result.toString());

            }
        });

    }

    public void calculateSum(View view)
    {
        final int first = Integer.parseInt(txtFirstValue.getText().toString());
        final int second = Integer.parseInt(txtSecondValue.getText().toString());
        final Integer result = first - second;
        txtResultValue.setText(result.toString());
    }

    public void calculateDiv(View view)
    {
        final int first = Integer.parseInt(txtFirstValue.getText().toString());
        final int second = Integer.parseInt(txtSecondValue.getText().toString());
        final Integer result = first / second;
        txtResultValue.setText(result.toString());
    }

    public void calculateMul(View view)
    {
        final int first = Integer.parseInt(txtFirstValue.getText().toString());
        final int second = Integer.parseInt(txtSecondValue.getText().toString());
        final Integer result = first * second;
        txtResultValue.setText(result.toString());
    }
}
