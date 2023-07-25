package com.example.roomlibarary2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface Expensedoa {
    @Query("Select * from Expense")
    List<Expense> allexpense();

    @Insert
    Void adtx(Expense expense);
    @Update
    void updatetx(Expense expense);
    @Delete
    void  deletetx(Expense expense);


}
