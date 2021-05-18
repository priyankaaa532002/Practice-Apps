package com.example.roomtodo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
//STEP 1--> MAKING DATABASE CLASS WHICH SHOULD BE AN ABSTRACT CLASS
//Making abstract class (we cant make objects for abstract class
//objects must be extracted from a different class
//iske methods ko koi aur initialize karta hai


@Database(entities = {Todo.class}, version = 1) //Step 1. @Database
public abstract class TodoRoomDatabase extends RoomDatabase {
    //Step 2. should be abstract       //3.extends RoomDatabase
    public abstract TodoDao todoDao();//Step 5.
    //singleton pattern
    private static volatile TodoRoomDatabase INSTANCE;

    static TodoRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (TodoRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TodoRoomDatabase.class, "Todo_Database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
