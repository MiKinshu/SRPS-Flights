package com.example.android.querymaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.android.querymaster.MainActivity.RegUsers;
import static com.example.android.querymaster.MainActivity.user;

public class Signup_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_);
        final EditText ETusername=findViewById(R.id.ETusername);
        final EditText ETpassword=findViewById(R.id.ETpassword);
        final EditText ETemail=findViewById(R.id.ETemail);
        final EditText ETage=findViewById(R.id.ETage);
        final EditText ETcontactno=findViewById(R.id.ETcontactno);
        Button BTNregister=findViewById(R.id.BTNregister);
        BTNregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username=ETusername.getText().toString();
                String pwd=ETpassword.getText().toString();
                String email=ETemail.getText().toString();
                int age=Integer.parseInt(ETage.getText().toString());
                int contactno=Integer.parseInt(ETcontactno.getText().toString());
                if(RegUsers.containsKey(Username)){
                    Toast.makeText(Signup_Activity.this, "User already exists, Please use another name.", Toast.LENGTH_SHORT).show();
                }
                else {
                    UserCredential user1 = new Customer(Username, pwd, email, age, 6969, 94250);
                    RegUsers.put(Username, user1);
                    Intent intent = new Intent(Signup_Activity.this, com.example.android.querymaster.Login_Activity.class);
                    startActivity(intent);
                    Signup_Activity.this.finish();
                }
            }
        });
    }
}
