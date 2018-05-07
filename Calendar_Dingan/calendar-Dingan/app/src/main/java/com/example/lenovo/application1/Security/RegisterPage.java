package com.example.lenovo.application1.Security;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.application1.R;

public class RegisterPage extends AppCompatActivity implements View.OnClickListener {


        private Button register;
        private TextView bkLogin;
        private EditText username, password;
        private DBHelperLogin db;
        ActionBar actionBar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register_page);
            actionBar = getSupportActionBar();
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6347")));

            db = new DBHelperLogin(this);
            register = (Button)findViewById(R.id.btnRegister);
            bkLogin = (TextView)findViewById(R.id.bkLogin);
            username = (EditText)findViewById(R.id.username);
            password = (EditText)findViewById(R.id.password);
            register.setOnClickListener(this);
            bkLogin.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btnRegister:
                    register();
                    break;
                case R.id.bkLogin:
                    startActivity(new Intent(RegisterPage.this,Loginpage.class));
                    finish();
                    break;
                default:
            }
        }
        private void  register(){
            String email = username.getText(). toString();
            String pass = password.getText().toString();
            if(email.isEmpty() && pass.isEmpty()) {
                displayToast("Username/password field empty");
            }else {
                db.addUser(email,pass);
                displayToast("User registered");
                finish();

            }
        }
        private  void displayToast(String message){
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
        }


}
