package com.example.protrack;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

public class AddActivity extends AppCompatActivity {
    EditText title_input,description_input,statue_input;
   Button addPButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        description_input  = findViewById(R.id.description_input);
        statue_input  = findViewById(R.id.statue_input);
        addPButton = findViewById(R.id.addPButton);

        addPButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MyDatabase myDB = new MyDatabase(AddActivity.this);
                myDB.addProject(title_input.getText().toString().trim(),
                        description_input.getText().toString().trim(),
                        statue_input.getText().toString().trim());
                finish();
            }
        });



    }

}