package com.fyp.andaruad.nutriscan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
// Created by Andaruad on 03/03/2016.

public class DBHandler extends SQLiteOpenHelper {

    // database version
	private static final int DATABASE_VERSION = 1;
	// database name
	private static final String DATABASE_NAME = "productsdatabase";
	private static final String TABLE_PRODUCTS = "products";
	private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "_name";
	private static final String COLUMN_BARCODE = "barcode";
	private static final String COLUMN_CATEGORY = "category";
    private final ArrayList<Product> product_list = new ArrayList<Product>();

	private static final String[] COLUMNS = { COLUMN_ID, COLUMN_NAME, COLUMN_BARCODE, COLUMN_CATEGORY };

	public DBHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// SQL statement to create book table
		String CREATE_DATABASE_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                COLUMN_ID + " TEXT" + COLUMN_BARCODE+ " TEXT" + COLUMN_CATEGORY + " TEXT" + ")";
		db.execSQL(CREATE_DATABASE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// drop books table if already exists
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
		onCreate(db);
    }
	public void addProduct(Product product){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, product.getP_name()); // Product Name
        values.put(COLUMN_BARCODE, product.getP_barcode()); // Product Barcode
        values.put(COLUMN_CATEGORY, product.getP_category()); // Product Calories
        // Inserting Row
        db.insert(TABLE_PRODUCTS, null, values);
        db.close(); // Closing database connection
    }
    Product Get_Product(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCTS, new String[] { COLUMN_ID,
                        COLUMN_NAME, COLUMN_BARCODE, COLUMN_CATEGORY }, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Product product = new Product(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        // return product
        cursor.close();
        db.close();

        return product;
    }
    // Getting All Contacts
    public ArrayList<Product> Get_Product() {
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
                    product.setId(Integer.parseInt(cursor.getString(0)));
                    product.setP_name(cursor.getString(1));
                    product.setP_barcode(cursor.getString(2));
                    product.setP_category(cursor.getString(3));
                    // Adding contact to list
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
    public int Update_Product(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, product.getP_name());
        values.put(COLUMN_BARCODE, product.getP_barcode());
        values.put(COLUMN_CATEGORY, product.getP_category());

        // updating row
        return db.update(TABLE_PRODUCTS, values, COLUMN_ID + " = ?",
                new String[] { String.valueOf(product.getId()) });
    }
    // Deleting single contact
    public void Delete_Product(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }
    // Getting contacts Count
    public int Get_Total_Contacts() {
        String countQuery = "SELECT  * FROM " + TABLE_PRODUCTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
