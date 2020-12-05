package com.example.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {

    TextInputLayout nameEt,passwordEt,rePasswordET;
    databaseHelperOne DBHelperOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameEt = findViewById(R.id.userNameET);
        passwordEt = findViewById(R.id.passwordET);
        rePasswordET = findViewById(R.id.retypePasswordET);

        DBHelperOne = new databaseHelperOne(this);

    }

    public void register(View view) {

        String user = nameEt.getEditText().getText().toString().trim();
        String pass = passwordEt.getEditText().getText().toString().trim();
        String rePass = rePasswordET.getEditText().getText().toString().trim();

        if (user.equals("") || pass.equals("") || rePass.equals("")){
            Toast.makeText(this, "Please fill up all the field", Toast.LENGTH_SHORT).show();
        }

        else {
            if (pass.equals(rePass)){
                DBHelperOne.insertData(user,pass);
                Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistrationActivity.this,LogInActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "password not matching", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void login(View view) {

        Intent intent = new Intent(RegistrationActivity.this,LogInActivity.class);
        startActivity(intent);
    }
}