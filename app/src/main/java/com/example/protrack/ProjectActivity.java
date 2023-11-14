package com.example.protrack;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.protrack.Adapter.ProjectsListAdapter;
import com.example.protrack.Database.RoomDB;
import com.example.protrack.Models.Project;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ProjectActivity extends AppCompatActivity  implements PopupMenu.OnMenuItemClickListener {

    RecyclerView recyclerView;
    ProjectsListAdapter  projectsListAdapter;
    List<Project> projects = new ArrayList<>();
    RoomDB database;
    FloatingActionButton float_add_btn;
    SearchView searchWidget;
    Project selectedProject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        recyclerView = findViewById(R.id.recycler_view);
        float_add_btn = findViewById(R.id.float_add_btn);
        searchWidget=findViewById(R.id.searchWidget);

        database = RoomDB.getInstance(this);
        projects = database.mainDAO().getAll();

        updateRecycler(projects);

        float_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ProjectActivity.this, AddActivity.class);
                startActivityForResult(intent, 101);
            }
        });


        searchWidget.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String newText) {
        List<Project> filterList =new ArrayList<>();
        for(Project singleProject : projects){
            if(singleProject.getTitle().toLowerCase().contains(newText.toLowerCase())
                    || singleProject.getDescription().toLowerCase().contains(newText.toLowerCase())){
                filterList.add(singleProject);
            }
        }
        projectsListAdapter.filterList(filterList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101){
            if(resultCode== Activity.RESULT_OK ){
                Project new_project = (com.example.protrack.Models.Project) data.getSerializableExtra("Project");
                database.mainDAO().insert(new_project);
                projects.clear();
                projects.addAll(database.mainDAO().getAll());
                projectsListAdapter.notifyDataSetChanged();

            }
        } else if (requestCode==102) {
            if (resultCode==Activity.RESULT_OK){
                Project new_project = (Project) data.getSerializableExtra("project");
                database.mainDAO().update(new_project.getId(),new_project.getTitle(),new_project.getDescription());
                projects.clear();
                projects.addAll(database.mainDAO().getAll());
                projectsListAdapter.notifyDataSetChanged();
            }

        }
    }

    private void updateRecycler(List<Project> projects) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        projectsListAdapter = new ProjectsListAdapter(ProjectActivity.this, projects, projectsClickListener);
        recyclerView.setAdapter(projectsListAdapter);
    }

    private final ProjectsClickListener projectsClickListener= new ProjectsClickListener() {
        @Override
        public void onClick(com.example.protrack.Models.Project project) {
            Intent intent=new Intent(ProjectActivity.this, updateProject.class);
            intent.putExtra("old_project",project);
            startActivityForResult(intent, 102);
        }

        @Override
        public void onLongClick(com.example.protrack.Models.Project projects, CardView cardView) {
            selectedProject=new Project();
            selectedProject = projects;
            showPopup(cardView);
        }
    };

    private void showPopup(CardView cardView) {
        PopupMenu popupMenu=new PopupMenu(this, cardView);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem Item) {
        int itemId = Item.getItemId();
        if (itemId == R.id.pin) {
            if (selectedProject.isActive()) {
                database.mainDAO().isActive(selectedProject.getId(), false);
                Toast.makeText(ProjectActivity.this, "inactive", Toast.LENGTH_SHORT).show();
            } else {
                database.mainDAO().isActive(selectedProject.getId(), true);
                Toast.makeText(ProjectActivity.this, "Active", Toast.LENGTH_SHORT).show();
            }

            projects.clear();
            projects.addAll(database.mainDAO().getAll());
            projectsListAdapter.notifyDataSetChanged();
            return true;
        } else if (itemId == R.id.delete && selectedProject.isActive()) {
            projectsListAdapter.notifyDataSetChanged();
            Toast.makeText(ProjectActivity.this, "this project is active, you Can't delete", Toast.LENGTH_SHORT).show();
        }else{
            database.mainDAO().delete(selectedProject);
           // projects.remove(selectedProject);
            projects.clear();
            projects.addAll(database.mainDAO().getAll());
            projectsListAdapter.notifyDataSetChanged();
            Toast.makeText(ProjectActivity.this, "Project Deleted", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;

    }
    @Override
    protected void onResume() {
        super.onResume();

        // Reload the data when the activity resumes
        projects.clear();
        projects.addAll(database.mainDAO().getAll());
        projectsListAdapter.notifyDataSetChanged();
    }

}