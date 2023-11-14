package com.example.formulaire;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

public class MyApplication extends Application {
    public static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyApplication", "Application onCreate");
        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "my-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

    }
}

