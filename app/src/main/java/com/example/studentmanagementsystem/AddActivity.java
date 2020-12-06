package com.example.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class AddActivity extends AppCompatActivity {

    TextInputLayout nameET,idET,departmentET,contactET,genderET;
    databaseHelperTwo DBHelperTWO;
    RadioGroup radioGroupID;
    RadioButton radioButton;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        nameET = findViewById(R.id.nameET);
        idET = findViewById(R.id.idET);
       /* departmentET = findViewById(R.id.departmentET);*/
        contactET = findViewById(R.id.contactNumberET);
        /*genderET = findViewById(R.id.genderET);*/
        radioGroupID = findViewById(R.id.radioGroupID);
        spinner = findViewById(R.id.spinnerID);

        DBHelperTWO = new databaseHelperTwo(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.departmentArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void ADD(View view) {

        radioButton = findViewById(radioGroupID.getCheckedRadioButtonId());


        String name = nameET.getEditText().getText().toString().trim();
        String id = idET.getEditText().getText().toString().trim();
        /*String department = departmentET.getEditText().getText().toString().trim();*/
        String department = spinner.getSelectedItem().toString();
        String contact = contactET.getEditText().getText().toString().trim();
        /*String gender = genderET.getEditText().getText().toString().trim();*/
        String gender = radioButton.getText().toString();



        if(name.isEmpty()){
            Toast.makeText(AddActivity.this, "Please enter  name", Toast.LENGTH_SHORT).show();
        }
        else if(id.isEmpty()){
            Toast.makeText(AddActivity.this, "Please enter ID", Toast.LENGTH_SHORT).show();
        }
        else if(department.isEmpty()){
            Toast.makeText(AddActivity.this, "Please enter Department", Toast.LENGTH_SHORT).show();
        }
        else if(contact.isEmpty()){
            Toast.makeText(AddActivity.this, "Please enter contact Number", Toast.LENGTH_SHORT).show();
        }
        else if(gender.isEmpty()){
            Toast.makeText(AddActivity.this, "Please enter gender", Toast.LENGTH_SHORT).show();
        }
        else {

            long colID = DBHelperTWO.insertData(name,id,department,contact,gender);

            Toast.makeText(AddActivity.this, "Data insert", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddActivity.this,MainActivity.class);
            startActivity(intent);


        }

    }
}