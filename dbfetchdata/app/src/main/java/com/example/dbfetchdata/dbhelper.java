package com.example.dbfetchdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbhelper extends SQLiteOpenHelper {
    private static final String db_name="Contacts";
    private static final int db_version=1;
    private static final String table_name="Contacts";
    private static final String Key_id="id";
    private static final String Name="name";
    private static final String contacts="contact";

    public dbhelper( Context context) {
        super(context, db_name, null, db_version);



    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+table_name+"("+Key_id+"INTEGER PRIMARY KEY AUTOINCREMENT ,"+Name+"Text ,"+contacts+"Text"+")");






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);

    }
    public void addcontact(String name,String contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Name,name);
        values.put(contacts,contact);
        db.insert("item",null,values);



    }
    public ArrayList<list> fetchdata (){
        SQLiteDatabase database=this.getReadableDatabase();
       Cursor cursor= database.rawQuery("SELECT * FROM "+table_name,null);
        ArrayList<list> arrayList=new ArrayList<>();
        while (cursor.moveToNext()) {
            list lst = new list();
            lst.id=cursor.getInt(0);
            lst.name=cursor.getString(1);
            lst.contact=cursor.getString(2);
            arrayList.add(lst);

        }
        return arrayList;

    }
}
