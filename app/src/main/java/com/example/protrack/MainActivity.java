package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button ProjectsNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ProjectsNavigation = (Button) findViewById(R.id.ProjectsNavigation);

        ProjectsNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProjectActivity.class);
                startActivity(intent);
                finish(); // Finish the current activity if needed
            }
        });
    }
}