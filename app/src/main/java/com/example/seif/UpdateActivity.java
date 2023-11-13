package com.example.seif;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.seif.dao.NoteDao;
import com.example.seif.database.AppDataBase;
import com.example.seif.entity.Note;

public class UpdateActivity extends AppCompatActivity {
  private   EditText titleEt,contentEt,creationDateEt,lastModifiedDateEt,statusEt,projectIdEt;
    Button updatebtn;
    private Note note;
    private AppDataBase appDataBase;
    private NoteDao noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        appDataBase=AppDataBase.getAppDataBase(this);
        noteDao=appDataBase.getDao();

        titleEt=findViewById(R.id.titleEt);
        contentEt=findViewById(R.id.contentEt);
        creationDateEt=findViewById(R.id.creationDateEt);
        lastModifiedDateEt=findViewById(R.id.lastModifiedDateEt);
        statusEt=findViewById(R.id.statusEt);
        projectIdEt=findViewById(R.id.projectIdEt);
        updatebtn=findViewById(R.id.update);

        note=(Note) getIntent().getSerializableExtra("model");
        titleEt.setText(note.getTitle());
        contentEt.setText(note.getContent());
        creationDateEt.setText(note.getCreationDate());
        lastModifiedDateEt.setText(note.getLastModifiedDate());
        statusEt.setText(note.getStatus());
        projectIdEt.setText(String.valueOf(note.getProjectId()));

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                Note noteModel=new Note(note.getId(),title,content,creationDate,lastModifiedDate,status,projectId);
                noteDao.update(noteModel);
                finish();
            }
        });
    }
}