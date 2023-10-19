package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ProjectActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private FloatingActionButton addPbtn;
    MyDatabase myDB;
    ArrayList<String> project_id,project_title,project_description,project_type,project_owner,project_groupe,project_statue;
    CustomAdapter customAdapter;
    //@SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        addPbtn = (FloatingActionButton) findViewById(R.id.addPbtn);
        addPbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectActivity.this, AddActivity.class);
                startActivity(intent);
              //  finish();
            }
        });



        myDB =new MyDatabase(ProjectActivity.this);
        project_id = new ArrayList<>();
        project_title= new ArrayList<>();
        project_description= new ArrayList<>();
        project_statue= new ArrayList<>();

        storeDataInArrays();

      customAdapter = new CustomAdapter(ProjectActivity.this,project_id,project_title,project_description,project_statue);
      recyclerView.setAdapter(customAdapter);
      recyclerView.setLayoutManager(new LinearLayoutManager(ProjectActivity.this));
    }
    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Log.d("get all project ","No Data");
        }else {
            while (cursor.moveToNext()){

                project_id.add(cursor.getString(0));
                project_title.add(cursor.getString(1));
                project_description.add(cursor.getString(2));
                project_statue.add(cursor.getString(3));
            }
        }
    }

}
