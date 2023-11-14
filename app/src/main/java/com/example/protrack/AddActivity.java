package com.example.protrack;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.protrack.Database.MainDataAccesData;
import com.example.protrack.Database.RoomDB;
import com.example.protrack.Models.Project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddActivity extends AppCompatActivity {
    EditText title_input,description_input;
   Button addPButton;
    Button CancelButton;
    Project project;

    boolean isOldProject=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        CancelButton = findViewById(R.id.CancelButton);

        addPButton = findViewById(R.id.addPButton);
        title_input = findViewById(R.id.title_input);
        description_input = findViewById(R.id.description_input);


        project =new Project();
        try{
            project= (com.example.protrack.Models.Project) getIntent().getSerializableExtra("old_note");
            title_input.setText(project.getTitle());
            description_input.setText(project.getDescription());
            isOldProject = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        addPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = title_input.getText().toString();
                String description =description_input.getText().toString();

                if(description.isEmpty()){
                    Toast.makeText(AddActivity.this, "Please add description!", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm a");
                Date date= new Date();


                    project = new Project();

                project.setTitle(title);
                project.setDescription(description);
                project.setCeratAt(formatter.format(date));
                RoomDB database = RoomDB.getInstance(AddActivity.this);
                MainDataAccesData mainDAO = database.mainDAO();


                    mainDAO.insert(project);


            /*    Intent intent = new Intent();
                intent.putExtra("project", project);
                setResult(Activity.RESULT_OK, intent);*/
               finish();
            }
        });
        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}