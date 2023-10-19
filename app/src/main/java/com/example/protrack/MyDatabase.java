package com.example.protrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    private static final String COLUMN_ID ="_id";
    private static final String COLUMN_TITLE ="project_title";
    private static final String COLUMN_DESCRIPTION ="project_description";
    private static final String COLUMN_TYPE ="project_type";
    private static final String COLUMN_OWNER ="project_owner";
    private static final String COLUMN_STATUE ="project_statue";
    private static final String COLUMN_GROUP ="project_groupe";
   /** public enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED,
        CANCELED,
        BLOCKED,
    }*/


    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE "+TABLE_NAME+"("+
                COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_TITLE +" Text,"+
                COLUMN_DESCRIPTION +" Text,"+
                COLUMN_STATUE +" Text,"+");";
        db.execSQL(query);
        try {
            db.execSQL(query);
            Log.d("MyDatabase", "Database created");
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();

        } catch (SQLException e) {
            Log.e("MyDatabase", "Database creation failed: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    void addProject(String title, String description ,String statue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data =new ContentValues();

        data.put(COLUMN_TITLE,title);
        data.put(COLUMN_DESCRIPTION,description);
        data.put(COLUMN_STATUE, "In Progress");
        long result =db.insert(TABLE_NAME,null,data);
        if(result ==-1){
            Log.d("insert","Project Add :Failed");
        }
        else {
            Log.d("insert","Project Added Successfully ");
        }
    }

    Cursor readAllData(){
        String query ="SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db =this.getReadableDatabase();

        Cursor cursor =null;
        if (db !=null){ cursor =db.rawQuery(query,null);}
        return cursor;
    }
}
