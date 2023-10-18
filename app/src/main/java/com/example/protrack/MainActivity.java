package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    private Button ProjectsNavigation;
    private FloatingActionButton addPbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        /*** from main to add project****/

        addPbtn = (FloatingActionButton) findViewById(R.id.addPbtn);
        addPbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
                finish(); // Finish the current activity if needed
            }
        });

    }
}