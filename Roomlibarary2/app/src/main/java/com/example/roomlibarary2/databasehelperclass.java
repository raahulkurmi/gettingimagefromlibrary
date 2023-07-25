package com.example.roomlibarary2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
@Database(entities = Expense.class,exportSchema = false,version = 1)
public abstract  class databasehelperclass extends RoomDatabase {
}
