package com.example.protrack.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

//@Entity(tableName = "projects")
@Entity()
public class Project implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int id=0;

    @ColumnInfo(name="title")
    String title ="";
    @ColumnInfo(name="description")
    String description ="";
    @ColumnInfo(name="creatAt")
    String ceratAt ;
    @ColumnInfo(name="active")
    boolean active = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCeratAt() {
        return ceratAt;
    }

    public void setCeratAt(String ceratAt) {
        this.ceratAt = ceratAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }




}
