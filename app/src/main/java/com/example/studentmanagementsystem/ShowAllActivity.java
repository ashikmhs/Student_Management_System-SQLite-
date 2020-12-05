package com.example.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ShowAllActivity extends AppCompatActivity {

    databaseHelperTwo DBHelperTwo;
    RecyclerView recyclerView;
    StudentAdapter adapter;
    List<Student>studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        DBHelperTwo = new databaseHelperTwo(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentList = new ArrayList<>();
        adapter = new StudentAdapter(studentList);
        recyclerView.setAdapter(adapter);

        Cursor cursor = DBHelperTwo.showData();

        while (cursor.moveToNext()){

            int ID = cursor.getInt(cursor.getColumnIndex(DBHelperTwo.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_NAME));
            String id = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_STUDENT_ID));
            String department = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_DEPARTMENT));
            String contact = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_CONTACT));
            String gender = cursor.getString(cursor.getColumnIndex(DBHelperTwo.COL_GENDER));

            studentList.add(new Student(ID,name,id,department,contact,gender));
            adapter.notifyDataSetChanged();
        }


    }
}