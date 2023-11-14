package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.protrack.Database.MainDataAccesData;
import com.example.protrack.Database.RoomDB;
import com.example.protrack.Models.Project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class updateProject extends AppCompatActivity {

    EditText title_inputU, description_inputU;
    Button updateButton;
    Button CancelButton;
    Project project;
    boolean isOldProject = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_project);

        updateButton= findViewById(R.id.updateButton);
        title_inputU = findViewById(R.id.title_inputU);
        description_inputU = findViewById(R.id.description_inputU);
        CancelButton = findViewById(R.id.CancelButton);


        project =new Project();
        try{
            project= (com.example.protrack.Models.Project) getIntent().getSerializableExtra("old_project");
            title_inputU.setText(project.getTitle());
            description_inputU.setText(project.getDescription());
            isOldProject = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = title_inputU.getText().toString();
                String description =description_inputU.getText().toString();

                if(description.isEmpty()){
                    Toast.makeText(updateProject.this, "Please add description!", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm a");
                Date date= new Date();

                project.setTitle(title);
                project.setDescription(description);
                project.setCeratAt(formatter.format(date));
                RoomDB database = RoomDB.getInstance(updateProject.this);
                MainDataAccesData mainDAO = database.mainDAO();

                if (isOldProject) {
                    // Update existing project
                    mainDAO.update(project.getId(), project.getTitle(), project.getDescription());
                }
                Intent intent = new Intent();
                intent.putExtra("project", project);
                setResult(Activity.RESULT_OK, intent);
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