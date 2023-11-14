package com.example.formulaire;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface InscrireDao {
    @Insert
    void insert(Inscrire inscrire);

    @Query("SELECT * FROM inscrire_table WHERE specificEmail = :email AND specificPassword = :password")
    Inscrire getInscrireByEmailAndPassword(String email, String password);
    // Add other methods for database operations as needed
}
