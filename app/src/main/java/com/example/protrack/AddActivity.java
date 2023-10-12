package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText projectName;
    EditText projectDescription;
    EditText projectType;
    EditText projectGroupe;
    Button addPButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        projectName = findViewById(R.id.projectName);
         projectDescription  = findViewById(R.id.projectDescription);
        projectType  = findViewById(R.id.projectType);
        projectGroupe = findViewById(R.id.projectGroupe);
        addPButton = findViewById(R.id.addPButton);

        addPButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            }
        });


    }
}