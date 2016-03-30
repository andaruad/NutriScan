package com.fyp.andaruad.nutriscan;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "productManager";

    // Products table name
    private static final String TABLE_PRODUCTS = "products";

    // Products Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_BR_NO = "barcode_number";
    private static final String KEY_CATE = "category";
    private final ArrayList<Product> product_list = new ArrayList<Product>();

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_BR_NO + " TEXT," + KEY_CATE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void Add_Product(Product contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Product Name
        values.put(KEY_BR_NO, contact.getBarcodeNumber()); // Product barcode
        values.put(KEY_CATE, contact.getCate()); // Product category
        // Inserting Row
        db.insert(TABLE_PRODUCTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Product Get_Product(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_BR_NO, KEY_CATE}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        Product contact = null;

        if (cursor != null && cursor.moveToFirst()) {
            contact = new Product(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }

        // return contact
        cursor.close();
        db.close();

        return contact;
    }

    // Getting All Products
    public ArrayList<Product> Get_Products() {
        try {
            product_list.clear();

            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Product product = new Product();
                    product.setID(Integer.parseInt(cursor.getString(0)));
                    product.setName(cursor.getString(1));
                    product.setBarcodeNumber(cursor.getString(2));
                    product.setCate(cursor.getString(3));
                    // Adding product to list
                    product_list.add(product);
                } while (cursor.moveToNext());
            }

            // return contact list
            cursor.close();
            db.close();
            return product_list;
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("all_contact", "" + e);
        }

        return product_list;
    }

    // Updating single contact
    public int Update_Product(Product contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_BR_NO, contact.getBarcodeNumber());
        values.put(KEY_CATE, contact.getCate());

        // updating row
        return db.update(TABLE_PRODUCTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }

    // Deleting single contact
    public void Delete_Product(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    // Getting contacts Count
    public int Get_Total_Products() {
        String countQuery = "SELECT  * FROM " + TABLE_PRODUCTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
