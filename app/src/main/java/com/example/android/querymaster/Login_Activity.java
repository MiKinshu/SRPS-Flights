package com.example.android.querymaster;
import static com.example.android.querymaster.MainActivity.RegUsers;
import static com.example.android.querymaster.MainActivity.user;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    /*@Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        System.exit(1);
    }*/
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        final EditText ETusername=findViewById(R.id.ETusername);
        final EditText ETpassword=findViewById(R.id.ETpassword);
        Button BTNsignin=findViewById(R.id.BTNregister);
        Button BTNsignup=findViewById(R.id.BTNsignup);
        BTNsignin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                //implementing sign in logic
                //if user found
                String name=ETusername.getText().toString();
                if(RegUsers.containsKey(name)){
                    if(RegUsers.get(name).getPassword().equals(ETpassword.getText().toString())){
                        user=RegUsers.get(name);
                        Intent intent= new Intent();
                        setResult(RESULT_OK, intent);
                        Login_Activity.this.finish();
                    }
                    else
                        Toast.makeText(Login_Activity.this, "Incorrect password! Try again.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login_Activity.this, "User not found please recheck!", Toast.LENGTH_SHORT).show();
                }

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
