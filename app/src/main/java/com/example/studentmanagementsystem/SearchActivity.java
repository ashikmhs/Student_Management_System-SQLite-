package com.example.studentmanagementsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class SearchActivity extends AppCompatActivity {

    TextInputLayout idET;
    databaseHelperTwo DBHelperTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        idET = findViewById(R.id.idET);
        DBHelperTwo = new databaseHelperTwo(this);

    }

    public void search(View view) {

        String id = idET.getEditText().getText().toString().trim();

        Cursor cursor = DBHelperTwo.search(id);

        while (cursor.moveToNext()){

            int ID = cursor.getInt(cursor.getColumnIndex(DBHelperTwo.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_NAME));
            String studentId = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_STUDENT_ID));
            String department = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_DEPARTMENT));
            String contact = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_CONTACT));
            String gender = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_GENDER));


            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Search Result");
            dialog.setMessage(ID+"\n"+"Name: "+name+"\n"+"ID: "+studentId+"\n"+"Department: "+department+"\n"+"Contact: "+contact+"\n"+"Gender: "+gender);
            dialog.setCancelable(true);
            dialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();

                    Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });

            AlertDialog alertDialog = dialog.create();
            alertDialog.show();
        }
    }
}