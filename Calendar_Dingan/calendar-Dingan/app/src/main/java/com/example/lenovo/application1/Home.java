package com.example.lenovo.application1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.application1.Security.Loginpage;
import com.example.lenovo.application1.Security.RegisterPage;
import com.example.lenovo.application1.Security.Session;

public class Home extends AppCompatActivity {
    private Session session;
    private Button btnLogout;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        session = new Session(this);
        if(!session.loggedin()){
            Logout();
        }
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#a465d7")));
    }

    private void Logout() {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent (Home.this,Loginpage.class));
    }


    public void GotoMainActivity(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void Gotologin(View view) {
        Intent intent = new Intent(this,Loginpage.class);
        startActivity(intent);
    }

    public void Gotoregister(View view) {
        Intent intent = new Intent(this,RegisterPage.class);
        startActivity(intent);
    }
}
