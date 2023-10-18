package com.example.protrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME ="ProTrackBD.db";
    private static final int DATABASE_VERSION=1;

    private static final String TABLE_NAME="My_Protarck";
    private static final String COLOUMN_ID="_id";
    private static final String COLOUMN_TITLE="project_title";
    private static final String COLOUMN_DESCRIPTION="project_description";
    private static final String COLOUMN_TYPE="project_type";
    private static final String COLOUMN_OWNER="project_owner";
    private static final String COLOUMN_STATUE="project_statue";
    private static final String COLOUMN_GROUPE="project_members";
    public enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED,
        CANCELED,
        BLOCKED,
    }
/** use of statue exemple Status status = Status.IN_PROGRESS; ;;;int statusInt = cursor.getInt(statusColumnIndex); // Retrieve the integer value
 Status status = Status.values()[statusInt];  ***/

    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE "+TABLE_NAME+"("+
                  COLOUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                  COLOUMN_TITLE +" Text,"+
                COLOUMN_DESCRIPTION +" Text,"+
                COLOUMN_TYPE+" Text,"+
                  COLOUMN_OWNER+" Text,"+
                  COLOUMN_STATUE+" INTEGER,"+
                  COLOUMN_GROUPE+" Text"+");";
        db.execSQL(query);
        try {
            db.execSQL(query);
            Log.d("MyDatabase", "Database created");
        } catch (SQLException e) {
            Log.e("MyDatabase", "Database creation failed: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    void addProject(String title, String description ,String type,String groupe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data =new ContentValues();

        data.put(COLOUMN_TITLE,title);
        data.put(COLOUMN_DESCRIPTION,description);
        data.put(COLOUMN_TYPE,type);
        data.put(COLOUMN_GROUPE,groupe);
        long result =db.insert(TABLE_NAME,null,data);
        if(result ==-1){
            Log.d("insert","Failed");
        }
        else {
            Log.d("insert","Added");
        }




    }
}
