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

    @Query("Select * From projects Order By id Desc")
    List<Project> getAll();


    @Query("Update projects Set title =:title, description= :description where id =:id ")
    void update(int id ,String title,String description);

    @Delete
    void delete(Project project);
}
