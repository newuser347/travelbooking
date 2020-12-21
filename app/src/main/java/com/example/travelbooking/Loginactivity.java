package com.example.travelbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Loginactivity extends AppCompatActivity implements View.OnClickListener {
    EditText user,pass;
    Button login;
    String correct_username = "user1";
    String correct_password = "password1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_login);
        user=findViewById(R.id.unmae);
        pass=findViewById(R.id.pasword);
        login=findViewById(R.id.logbtn);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String verify = verifyLogin(user.getText().toString(), pass.getText().toString());
        if (verify.isEmpty())
            Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
        else if (user.getText().toString().equals(correct_username)) {
            if (pass.getText().toString().equals(correct_password)) {
                //Toast.makeText(getApplicationContext(), "successfully loggedin", Toast.LENGTH_LONG).show();


                //navigate to the MainActivity
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            }
        }


    }

    public String verifyLogin(String toString, String toString1) {
        return toString;
    }

    }

