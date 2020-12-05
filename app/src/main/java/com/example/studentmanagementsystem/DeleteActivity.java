package com.example.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class DeleteActivity extends AppCompatActivity {

    TextInputLayout idET;
    databaseHelperTwo DBHelperTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);


        idET = findViewById(R.id.idET);
        DBHelperTwo = new databaseHelperTwo(this);

    }

    public void delete(View view) {

        String id = idET.getEditText().getText().toString();

        if(id.isEmpty()){
            Toast.makeText(this, "Please Search First", Toast.LENGTH_SHORT).show();
        }
        else {
            int check = DBHelperTwo.deleteData(id);

            if(check>0){
                Toast.makeText(this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DeleteActivity.this,MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        }

    }
}