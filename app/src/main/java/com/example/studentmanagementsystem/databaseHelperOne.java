package com.example.studentmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseHelperOne extends SQLiteOpenHelper {

    public  static final  String DATABASE_NAME = "login.db";
    public  static final  String TABLE_NAME = "user";
    public  static final  String COL_USER_NAME = "username";
    public  static final  String COL_PASSWORD = "password";
    public  static final int VERSION = 1;

    private String CREATE_TABLE = "create table "+TABLE_NAME+"("+COL_USER_NAME+" TEXT primary key, "+COL_PASSWORD+" TEXT)";

    public databaseHelperOne(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
    }

    public  boolean insertData(String username,String password){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USER_NAME,username);
        contentValues.put(COL_PASSWORD,password);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        if (result == -1)
            return false;
        else
            return  true;
    }


    public boolean checkUsernamePassword(String username, String password){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from "+TABLE_NAME+" where "+COL_USER_NAME+" = ? and "+COL_PASSWORD+" = ?",new  String[] {username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
