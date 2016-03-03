package com.fyp.andaruad.nutriscan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
// Created by Andaruad on 03/03/2016.

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProductsDB.DB";
    private static final String TABLE_PRODUCTS = "ProductsDB";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCTNAME = "p_barcode";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE" + TABLE_PRODUCTS + "(" +
                COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT" +
                COLUMN_PRODUCTNAME + "TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    //Add new row to database
    public void addProduct(ProductsDB productsDB){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, productsDB.getP_barcode());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }
    //Delete product from DB
    public void delProduct (String p_barcode){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM" + TABLE_PRODUCTS + "WHERE" + COLUMN_PRODUCTNAME + "=\"" + p_barcode + "\";");
    }

    //get database into string
    public String databasetoString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM" + TABLE_PRODUCTS + "WHERE 1";

        //CURSOR POINT TO A LOCATION IN RESULT
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("p_barcode"))!= null){
                dbString += c.getString(c.getColumnIndex("p_barcode"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }

}
