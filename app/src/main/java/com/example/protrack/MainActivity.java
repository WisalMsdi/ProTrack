package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.protrack.Database.RoomDB;
import com.example.protrack.Models.Project;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RoomDB database;
    List<Project> projects = new ArrayList<>();


    private Button ProjectsNavigation;
    private FloatingActionButton addPbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*******copie*******/
        database = RoomDB.getInstance(this);
        projects = database.mainDAO().getAll();


        /*** from main to projects****/
        this.ProjectsNavigation = (Button) findViewById(R.id.ProjectsNavigation);

        ProjectsNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProjectActivity.class);
                startActivity(intent);
                finish(); // Finish the current activity if needed
            }
        });
        addPbtn = findViewById(R.id.addPbtn);

        addPbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 101);
            }
        });

    }
}