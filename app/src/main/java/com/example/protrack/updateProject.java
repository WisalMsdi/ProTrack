package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class updateProject extends AppCompatActivity {

    EditText title_inputu,description_inputu,statue_inputu;
    Button UpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_project);

        title_inputu = findViewById(R.id.title_inputU);
        description_inputu  = findViewById(R.id.description_inputU);
        statue_inputu  = findViewById(R.id.statue_inputU);
        UpdateButton = findViewById(R.id.updateButton);



    }
}