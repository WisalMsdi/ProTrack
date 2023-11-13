package tn.esprit.achraf.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(tableName = "Reunion")
public class Reunion implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "sujet")

    private String sujet;
    @ColumnInfo(name = "dateDebut")

    private String dateDebut;

    @ColumnInfo(name = "dateFin")
    private String dateFin;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public Reunion() {
    }

    public Reunion(int id, String sujet, String dateDebut, String dateFin) {
        this.id = id;
        this.sujet = sujet;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Reunion(String sujet, String dateDebut, String dateFin) {
        this.sujet = sujet;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Reunion{" +
                "id=" + id +
                ", sujet='" + sujet + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin='" + dateFin + '\'' +
                '}';
    }
}
