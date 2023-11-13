package com.example.seif.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.seif.dao.NoteDao;
import com.example.seif.entity.Note;

@Database(entities ={Note.class} ,version = 2)
public abstract class AppDataBase extends RoomDatabase {

    public abstract NoteDao getDao();
    private static AppDataBase instance ;


    public static AppDataBase getAppDataBase(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "Test5SAE3")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return instance;
    }
}
