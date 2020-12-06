package com.example.studentmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbarID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarID = findViewById(R.id.toolbarID);

        setSupportActionBar(toolbarID);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logOutID:
                Intent intent = new Intent(MainActivity.this,LogInActivity.class);
                startActivity(intent);
                break;
            case R.id.shareID:
                shareApp();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void shareApp() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void addStudent(View view) {
        Intent intent = new Intent(MainActivity.this,AddActivity.class);
        startActivity(intent);
    }

    public void searchStudent(View view) {
        Intent intent = new Intent(MainActivity.this,SearchActivity.class);
        startActivity(intent);
    }

    public void showAll(View view) {
        Intent intent = new Intent(MainActivity.this,ShowAllActivity.class);
        startActivity(intent);
    }

    public void updateStudent(View view) {
        Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
        startActivity(intent);
    }

    public void deleteStudent(View view) {
        Intent intent = new Intent(MainActivity.this,DeleteActivity.class);
        startActivity(intent);
    }

    public void about(View view) {

        Intent intent = new Intent(MainActivity.this,AboutActivity.class);
        startActivity(intent);
    }
}
