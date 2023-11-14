package com.example.formulaire;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Inscrire.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract InscrireDao inscrireDao(); // Add this line
}

