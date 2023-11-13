package com.example.seif;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.seif.dao.NoteDao;
import com.example.seif.database.AppDataBase;
import com.example.seif.entity.AdapterListener;
import com.example.seif.entity.Note;
import com.example.seif.entity.NoteAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterListener {


    Button saveBtn;
    EditText titleEt,contentEt,creationDateEt,lastModifiedDateEt,statusEt,projectIdEt;
    RecyclerView myrecycler;

    private AppDataBase appDataBase;
    private NoteDao noteDao;

    private NoteAdapter noteAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDataBase =AppDataBase.getAppDataBase(this);
        noteDao = appDataBase.getDao();



        titleEt=findViewById(R.id.titleEt);
        contentEt=findViewById(R.id.contentEt);
        creationDateEt=findViewById(R.id.creationDateEt);
        lastModifiedDateEt=findViewById(R.id.lastModifiedDateEt);
        statusEt=findViewById(R.id.statusEt);
        projectIdEt=findViewById(R.id.projectIdEt);
        saveBtn=findViewById(R.id.saveBtn);
        myrecycler=findViewById(R.id.noteRecycler);


        noteAdapter=new NoteAdapter(this,this);
        myrecycler.setAdapter(noteAdapter);
        myrecycler.setLayoutManager(new LinearLayoutManager(this));


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEt.getText().toString();
                String content = contentEt.getText().toString();
                String creationDate = creationDateEt.getText().toString();
                String lastModifiedDate = lastModifiedDateEt.getText().toString();
                String status = statusEt.getText().toString();
                int projectId = 0; // Valeur par défaut ou une valeur appropriée si projectIdEt est vide.
                try {
                    projectId = Integer.parseInt(projectIdEt.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace(); // Gérer l'exception selon vos besoins (par exemple, afficher un message d'erreur à l'utilisateur)
                }
                Note note=new Note(title,content,creationDate,lastModifiedDate,status,projectId);
                noteAdapter.addNote(note);
                noteDao.insert(note);
                titleEt.setText("");
                contentEt.setText("");
                creationDateEt.setText("");
                lastModifiedDateEt.setText("");
                statusEt.setText("");
                projectIdEt.setText("");
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();


            }
        });


    }
    private void fetchData(){
        noteAdapter.clearData();
        List<Note> noteList=noteDao.getAllNotes();
        for(int i=0;i<noteList.size();i++){
            Note note=noteList.get(i);
            noteAdapter.addNote(note);
        }
    }

    @Override
    public void OnUpdate(Note note) {
        Intent intent=new Intent(this, UpdateActivity.class);
        intent.putExtra("model",note);
        startActivity(intent);

    }

    @Override
    public void OnDelete(int id, int pos) {
        noteDao.delete(id);
        noteAdapter.removeNote(pos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();

    }
}