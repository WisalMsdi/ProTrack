package com.example.formulaire;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "inscrire_table")
public class Inscrire {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String specificEmail;
    private String specificPassword;

    // Constructor
    public Inscrire() {
        // Initialize properties as needed
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecificEmail() {
        return specificEmail;
    }

    public void setSpecificEmail(String specificEmail) {
        this.specificEmail = specificEmail;
    }

    public String getSpecificPassword() {
        return specificPassword;
    }

    public void setSpecificPassword(String specificPassword) {
        this.specificPassword = specificPassword;
    }
}
