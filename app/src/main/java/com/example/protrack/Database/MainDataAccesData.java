package com.example.protrack.Database;

import static androidx.room.OnConflictStrategy.REPLACE;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.protrack.Models.Project;

import java.util.List;

@Dao
public interface MainDataAccesData {
    @Insert(onConflict = REPLACE)
    void insert(Project project);

    @Query("SELECT * FROM Project ORDER By id DESC")
    List<Project> getAll();


    @Query("UPDATE Project SET title =:title, description= :description WHERE id =:id ")
    void update(int id ,String title,String description);


    @Query("update Project set active = :active where id = :id")
    void isActive(int id, boolean active);


    @Query("SELECT * FROM Project WHERE id = :projectId")
    Project getProjectById(int projectId);
    @Delete
    void delete(Project project);
}
