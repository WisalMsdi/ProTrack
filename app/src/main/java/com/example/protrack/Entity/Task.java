package com.example.protrack.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.protrack.config.StateConverter;

@Entity(tableName = "tasks")
@TypeConverters(StateConverter.class)
public class Task {

        @PrimaryKey(autoGenerate = true)
        private int id;

        private String name;
        private String description;


        private State state;

        private long dueDate;

        public Task(String name, String description, State state, long dueDate) {
                this.name = name;
                this.description = description;
                this.state = state;
                this.dueDate = dueDate;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public String getDescription() {
                return description;
        }

        public State getState() {
                return state;
        }

        public long getDueDate() {
                return dueDate;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setState(State state) {
                this.state = state;
        }

        public void setDueDate(long dueDate) {
                this.dueDate = dueDate;
        }
}

