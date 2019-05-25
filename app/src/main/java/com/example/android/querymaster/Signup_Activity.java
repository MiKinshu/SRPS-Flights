package com.example.android.querymaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Signup_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_);
        EditText ETusername=findViewById(R.id.ETusername);
        EditText ETpassword=findViewById(R.id.ETpassword);
        EditText ETemail=findViewById(R.id.ETemail);
        Button BTNsignup=findViewById(R.id.BTNsignup);
    }
}
