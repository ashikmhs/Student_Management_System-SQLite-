package com.example.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText idET,nameET,departmentET,contactET,genderET;
    databaseHelperTwo DBHelperTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        idET = findViewById(R.id.idET);
        nameET = findViewById(R.id.nameET);
        departmentET = findViewById(R.id.departmentET);
        contactET = findViewById(R.id.contactET);
        genderET = findViewById(R.id.genderET);

        DBHelperTwo = new databaseHelperTwo(this);


    }

    public void search(View view) {

        String ID = idET.getText().toString();

        if(ID.isEmpty()){
            Toast.makeText(this, "Enter ID for Search", Toast.LENGTH_SHORT).show();
        }
        else {
            Cursor cursor = DBHelperTwo.search(ID);

            while (cursor.moveToNext()){

                String name = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_NAME));
                String studentId = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_STUDENT_ID));
                String department = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_DEPARTMENT));
                String contact = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_CONTACT));
                String gender = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_GENDER));

                nameET.setText(name);
                idET.setText(studentId);
                departmentET.setText(department);
                contactET.setText(contact);
                genderET.setText(gender);
            }

        }
    }

    public void update(View view) {

        String ID = idET.getText().toString();
        String name = nameET.getText().toString();
        String department = departmentET.getText().toString();
        String contact = contactET.getText().toString();
        String gender = genderET.getText().toString();


        if(name.isEmpty() || department.isEmpty() || contact.isEmpty() || gender.isEmpty()){
            Toast.makeText(this, "Please Search First", Toast.LENGTH_SHORT).show();
        }
        else {
            boolean check = DBHelperTwo.updateData(name,ID,department,contact,gender);

            if(check){
                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateActivity.this,MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        }


    }
}