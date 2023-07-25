package com.example.roomlibarary2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Expense")
public class Expense {
   @PrimaryKey(autoGenerate = true)
    private int id;
   @ColumnInfo(name = "title")
   private String title;
   @ColumnInfo(name = "Amount")
   private String amount;

   public Expense(int id, String title, String amount) {
      this.id = id;
      this.title = title;
      this.amount = amount;
   }
   @Ignore
   public Expense( String title, String amount) {

      this.title = title;
      this.amount = amount;
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

   public String getAmount() {
      return amount;
   }

   public void setAmount(String amount) {
      this.amount = amount;
   }
}
