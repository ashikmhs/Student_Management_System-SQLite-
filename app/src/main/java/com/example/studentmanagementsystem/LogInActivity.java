package com.example.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LogInActivity extends AppCompatActivity {

    TextInputLayout nameEt,passwordEt;
    databaseHelperOne DBHelperOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        nameEt = findViewById(R.id.userNameET);
        passwordEt = findViewById(R.id.passwordET);

        DBHelperOne = new databaseHelperOne(this);


    }

    public void login(View view) {

        String user = nameEt.getEditText().getText().toString();
        String pass = passwordEt.getEditText().getText().toString();

        if (user.equals("") || pass.equals("")){
            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean checkUserPass = DBHelperOne.checkUsernamePassword(user,pass);
            if (checkUserPass.equals(true)){
                Toast.makeText(this, "Sign in successful ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LogInActivity.this,MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void register(View view) {
        Intent intent = new Intent(LogInActivity.this,RegistrationActivity.class);
        startActivity(intent);
    }

}