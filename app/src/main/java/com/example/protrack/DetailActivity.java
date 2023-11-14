package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.protrack.Database.MainDataAccesData;
import com.example.protrack.Database.RoomDB;
import com.example.protrack.Models.Project;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Use the correct key to retrieve the project ID
        int projectId = getIntent().getIntExtra("old_project", -1);

        // The rest of your code remains unchanged
        RoomDB database = RoomDB.getInstance(this);
        MainDataAccesData mainDAO = database.mainDAO();

        Project project = mainDAO.getProjectById(projectId);

        if (project != null) {
            String title = project.getTitle();
            String description = project.getDescription();

            // Use the details as needed in your activity
        }

        this.updateBtn = (Button) findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), updateProject.class);
                startActivity(intent);
                finish();
            }
        });
    }}
