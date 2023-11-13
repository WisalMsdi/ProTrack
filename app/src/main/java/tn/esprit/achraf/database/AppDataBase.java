package tn.esprit.achraf.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import tn.esprit.achraf.dao.ReunionDao;
import tn.esprit.achraf.entity.Reunion;


@Database(entities ={Reunion.class} ,version = 2)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ReunionDao getDao();
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
