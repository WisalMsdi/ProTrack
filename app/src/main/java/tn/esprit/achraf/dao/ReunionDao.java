package tn.esprit.achraf.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import tn.esprit.achraf.entity.Reunion;

@Dao
public interface ReunionDao {
    @Insert
    void insert(Reunion reunion);

    @Update
    void update(Reunion reunion);

    @Query("delete from Reunion where id=:id")
    void delete (int id);

    @Query("Select * from Reunion")
    List<Reunion> getAllReunion();
}
