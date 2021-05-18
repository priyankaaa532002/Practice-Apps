package com.example.roomtodo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//STEP 2-->
//tHIS IS AN ENTITY IE CONTAINS AN OBJECT CONTAINING THE TABLE
@Entity(tableName = "todo_table")
public class Todo {

    //Primary key auto increase
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_uid") // name defined
    private int uid; // it is of type integer

    @ColumnInfo(name = "todo_text") // name defined
    private String text; //which is a string

    @ColumnInfo(name = "todo_completed") // name defined
    private boolean completed; // type boolean

    //constructor-->this func is called whenever an object is declared/created
    // made with 2 arguments ie todo_text todo_completed
    public Todo(String text, boolean completed) {
        this.text = text;
        this.completed = completed;
    }

    //getter setter made for taking input and output for member variables including uid
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //alt insert , called toString()
    @Override
    public String toString() {
        return "Todo{" +
                "uid=" + uid +
                ", text='" + text + '\'' +
                ", completed=" + completed +
                '}';
    }
}
