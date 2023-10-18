package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText title_input,description_input,type_input,groupe_input;
   Button addPButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        description_input  = findViewById(R.id.description_input);
        type_input  = findViewById(R.id.type_input);
        groupe_input= findViewById(R.id.groupe_input);
        addPButton = findViewById(R.id.addPButton);

        addPButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MyDatabase myDB = new MyDatabase(AddActivity.this);
                myDB.addProject(title_input.getText().toString().trim(),
                        description_input.getText().toString().trim(),
                        type_input.getText().toString().trim(),
                        groupe_input.getText().toString().trim());

            }
        });


    }
}