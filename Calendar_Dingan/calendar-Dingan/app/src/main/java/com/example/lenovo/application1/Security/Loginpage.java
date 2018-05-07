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
import android.widget.Toast;

import com.example.lenovo.application1.Home;
import com.example.lenovo.application1.R;

public class Loginpage extends AppCompatActivity implements  View.OnClickListener{
    private Button login, register;
    private EditText username, password;
    private DBHelperLogin db;
    private Session session;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6347")));

        db = new DBHelperLogin(this);
        session = new Session(this);
        login = (Button)findViewById(R.id.btnLogin);
        register = (Button)findViewById(R.id.btnRegister);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.Password);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        if(session.loggedin()){
            startActivity(new Intent(Loginpage
                    .this,Home.class));
            finish();
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                login();

                break;
            case R.id.btnRegister:
                startActivity(new Intent(Loginpage.this,RegisterPage.class));

                break;
            default:
        }

    }

    private void login (){
        String email = username.getText().toString();
        String pass = password.getText().toString();

        if(db.getUser(email,pass)) {
            session.setLoggedin(true);
            startActivity(new Intent(Loginpage.this, Home.class));
            finish();
        }else {
            Toast.makeText(getApplicationContext(),"Wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }
}
