package tn.esprit.achraf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tn.esprit.achraf.dao.ReunionDao;
import tn.esprit.achraf.database.AppDataBase;
import tn.esprit.achraf.entity.Reunion;

public class UpdateReunionActivity extends AppCompatActivity {


    private EditText sujetEt,dateDebutEt,dateFinEt;
    Button updatebtn;
    private Reunion reunion;
    private AppDataBase appDataBase;
    private ReunionDao reunionDao;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_reunion);

        appDataBase=AppDataBase.getAppDataBase(this);
        reunionDao=appDataBase.getDao();

        sujetEt=findViewById(R.id.sujetEt);
        dateDebutEt=findViewById(R.id.dateDebutEt);
        dateFinEt=findViewById(R.id.dateFinEt);

        updatebtn=findViewById(R.id.update);

        reunion=(Reunion) getIntent().getSerializableExtra("model");
        sujetEt.setText(reunion.getSujet());
        dateDebutEt.setText(reunion.getDateDebut());
        dateFinEt.setText(reunion.getDateFin());

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sujet = sujetEt.getText().toString();
                String dateDebut = dateDebutEt.getText().toString();
                String dateFin = dateFinEt.getText().toString();


                Reunion reunionModel=new Reunion(reunion.getId(),sujet,dateDebut,dateFin);
                reunionDao.update(reunionModel);
                finish();
            }
        });





    }
}