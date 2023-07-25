package com.example.sqliteopenerhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbhelper extends SQLiteOpenHelper


{

    private static final String Database_Name="ContactdBS";
    private static final int Database_version= 1;
    private static final String Table_name="Contacts";
    private static final String Key_id="id";
    private static final String key_name="name";
    private static final String Key_phone="phone";

    public dbhelper( Context context) {

        super(context, Database_Name, null, Database_version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+Table_name+"("+ Key_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"+key_name+"Text , " + Key_phone+"Text "+")");
//        SQLiteDatabase db=this.getWritableDatabase();
//        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_name);
        onCreate(db);

    }
    public void addcontact(String name,String contact){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(key_name,name);
        values.put(Key_phone,contact);
        database.insert(Table_name,null,values);
    }
    public ArrayList<Contactmodel> fetch(){
        SQLiteDatabase db=this.getWritableDatabase();
       Cursor cursor= db.rawQuery("SELECT * FROM  "+ Table_name,null);
       ArrayList<Contactmodel> arrayList=new ArrayList<>();
       while (cursor.moveToNext()){
           Contactmodel model=new Contactmodel();
           model.id=cursor.getInt(0);
           model.name=cursor.getString(1);
           model.contact=cursor.getString(2);
           arrayList.add(model);
       }
       return arrayList;


    }
}
