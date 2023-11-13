package tn.esprit.achraf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import tn.esprit.achraf.dao.ReunionDao;
import tn.esprit.achraf.database.AppDataBase;
import tn.esprit.achraf.entity.Reunion;
import tn.esprit.achraf.entity.ReunionAdapter;
import tn.esprit.achraf.entity.ReunionAdapterListener;

public class MainActivity extends AppCompatActivity implements ReunionAdapterListener {


    Button saveBtn;
    EditText sujetEt,dateDebutEt,dateFinEt;
    RecyclerView myrecycler;


    private AppDataBase appDataBase;
    private ReunionDao reunionDao;

    private ReunionAdapter reunionAdapter;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDataBase =AppDataBase.getAppDataBase(this);
        reunionDao = appDataBase.getDao();



        sujetEt=findViewById(R.id.sujetEt);
        dateDebutEt=findViewById(R.id.dateDebutEt);
        dateFinEt=findViewById(R.id.dateFinEt);

        saveBtn=findViewById(R.id.saveBtn);
        myrecycler=findViewById(R.id.reunionRecycler);
        reunionAdapter=new ReunionAdapter(this,this);
        myrecycler.setAdapter(reunionAdapter);
        myrecycler.setLayoutManager(new LinearLayoutManager(this));

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sujet = sujetEt.getText().toString();
                String dateDebut = dateDebutEt.getText().toString();
                String dateFin = dateFinEt.getText().toString();


                Reunion reunion=new Reunion(sujet,dateDebut,dateFin);
                reunionAdapter.addReunion(reunion);
                reunionDao.insert(reunion);
                sujetEt.setText("");
                dateDebutEt.setText("");
                dateFinEt.setText("");

                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();


            }
        });



    }


    private void fetchData(){
        reunionAdapter.clearData();
        List<Reunion> reunionList=reunionDao.getAllReunion();
        for(int i=0;i<reunionList.size();i++){
            Reunion reunion=reunionList.get(i);
            reunionAdapter.addReunion(reunion);
        }
    }

    @Override
    public void OnUpdate(Reunion note) {
        Intent intent=new Intent(this, UpdateReunionActivity.class);
        intent.putExtra("model",note);
        startActivity(intent);

    }

    @Override
    public void OnDelete(int id, int pos) {
        reunionDao.delete(id);
        reunionAdapter.removeReunion(pos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();

    }



}