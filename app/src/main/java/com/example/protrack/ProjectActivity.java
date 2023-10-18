package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
public class ProjectActivity extends AppCompatActivity {

    private View projectWidget;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

     // projectWidget = findViewById(R.id.projectWidget);

     //   projectWidget.setOnClickListener(new View.OnClickListener() {
       //     @Override
         //   public void onClick(View view) {
           //     Intent intent = new Intent(ProjectActivity.this, DetailActivity.class);
             //   startActivity(intent);
           // }
        //});
    }
}
