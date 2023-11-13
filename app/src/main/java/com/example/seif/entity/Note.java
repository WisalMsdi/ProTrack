package com.example.seif.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Note")
public class Note implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "content")
    private String content;
    @ColumnInfo(name = "creationDate")
    private String creationDate;
    @ColumnInfo(name = "lastModifiedDate")
    private String lastModifiedDate;
    @ColumnInfo(name = "status")
    private String status;
    @ColumnInfo(name = "projectId")
   private int projectId;

    public Note() {
    }

    public Note(int id, String title, String content, String creationDate, String lastModifiedDate, String status, int projectId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.status = status;
        this.projectId = projectId;
    }

    public Note(String title, String content, String creationDate, String lastModifiedDate, String status, int projectId) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.status = status;
        this.projectId = projectId;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                ", status='" + status + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
