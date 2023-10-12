package com.example.protrack.config;

import androidx.room.TypeConverter;

import com.example.protrack.Entity.State;

public class StateConverter {
    @TypeConverter
    public static State fromString(String value) {
        return value == null ? null : State.valueOf(value);
    }

    @TypeConverter
    public static String toString(State state) {
        return state == null ? null : state.name();
    }
}

