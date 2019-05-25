package com.example.android.querymaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        EditText ETusername=findViewById(R.id.ETusername);
        EditText ETpassword=findViewById(R.id.ETpassword);
        Button BTNsignin=findViewById(R.id.BTNsignin);
        Button BTNforgotpassword=findViewById(R.id.BTNforgotpassword);
        Button BTNsignup=findViewById(R.id.BTNsignup);
        BTNsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implementing sign in logic
                //if user found

            }
        });
        BTNsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login_Activity.this,com.example.android.querymaster.Signup_Activity.class);
                startActivity(intent);
            }
        });
    }
}
