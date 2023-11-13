package com.example.seif.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.seif.entity.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Query("delete from Note where id=:id")
    void delete (int id);

    @Query("Select * from Note")
    List<Note> getAllNotes();

}
