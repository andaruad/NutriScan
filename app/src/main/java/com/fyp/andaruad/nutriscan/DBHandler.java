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
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String DATABASE_NAME = "productManager";

    // Products table name
    private static final String TABLE_PRODUCTS = "products";

    // Products Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_BR_NO = "barcode_number";
    private static final String KEY_CATE = "category";
    private static final String KEY_CAL = "calories";
    private static final String KEY_TOFAT = "total_fat";
    private static final String KEY_SFAT = "saturated_fat";
    private static final String KEY_TRFAT = "trans_fat";
    private static final String KEY_CHOLE = "cholesterol";
    private static final String KEY_SODIU = "sodium";
    private static final String KEY_CARBS = "carbohydrate";
    private static final String KEY_DIEFI = "dietary_fibre";
    private static final String KEY_SUGR = "sugar";
    private static final String KEY_PROTE = "protein";
    private static final String KEY_VITD = "vitamin_d";
    private static final String KEY_CALC = "calcium";
    private static final String KEY_IRON = "iron";
    private static final String KEY_POTAS = "potassium";
    private static final String KEY_SERSI = "serving_size";
    private final ArrayList<Product> product_list = new ArrayList<>();

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_BR_NO + " INTEGER," + KEY_CATE + " TEXT," + KEY_CAL + " INTEGER,"
                + KEY_TOFAT + " INTEGER," + KEY_SFAT + " INTEGER," + KEY_TRFAT+ " INTEGER,"
                + KEY_CHOLE + " INTEGER," + KEY_SODIU + " INTEGER," + KEY_CARBS + " INTEGER,"
                + KEY_DIEFI + " INTEGER," + KEY_SUGR + " INTEGER," + KEY_PROTE + " INTEGER,"
                + KEY_VITD +  " INTEGER," + KEY_CALC + " INTEGER," + KEY_IRON + " INTEGER,"
                + KEY_POTAS + " INTEGER," + KEY_SERSI + " INTEGER"
                + ");";
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
        values.put(KEY_CAL, contact.getCal());
        values.put(KEY_TOFAT, contact.get_tofat());
        values.put(KEY_SFAT, contact.get_sfat());
        values.put(KEY_TRFAT, contact.get_trfat());

        values.put(KEY_CHOLE, contact.get_chole());
        values.put(KEY_SODIU, contact.get_sodiu());
        values.put(KEY_CARBS, contact.get_carbs());
        values.put(KEY_DIEFI, contact.get_diefi());
        values.put(KEY_SUGR, contact.get_sugr());
        values.put(KEY_PROTE, contact.get_prote());
        values.put(KEY_VITD, contact.get_vitd());
        values.put(KEY_CALC,contact.get_calc());
        values.put(KEY_IRON, contact.get_iron());
        values.put(KEY_POTAS, contact.get_potas());
        values.put(KEY_SERSI, contact.get_sersi());
        // Inserting Row
        db.insert(TABLE_PRODUCTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Product Get_Product(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCTS, new String[] {
                        KEY_ID, KEY_NAME, KEY_BR_NO, KEY_CATE, KEY_CAL, KEY_TOFAT, KEY_SFAT, KEY_TRFAT,
                        KEY_CHOLE,KEY_SODIU,KEY_CARBS,KEY_DIEFI,KEY_SUGR,KEY_PROTE,KEY_VITD,KEY_CALC,
                        KEY_IRON,KEY_POTAS,KEY_SERSI

                }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);               //YOU MAY NEED TO ADD ONE MORE NULL

        Product contact = null;

        if (cursor != null && cursor.moveToFirst()) {
            contact = new Product(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)
                    ,cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12)
                    ,cursor.getString(13),cursor.getString(14),cursor.getString(15),cursor.getString(16),cursor.getString(17),cursor.getString(18));
        }

        // return contact
        cursor.close();
        db.close();

        return contact;
    }

    Product Get_Bar(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCTS, new String[] {
                        KEY_ID, KEY_NAME, KEY_BR_NO, KEY_CATE, KEY_CAL, KEY_TOFAT, KEY_SFAT, KEY_TRFAT,
                        KEY_CHOLE,KEY_SODIU,KEY_CARBS,KEY_DIEFI,KEY_SUGR,KEY_PROTE,KEY_VITD,KEY_CALC,
                        KEY_IRON,KEY_POTAS, KEY_SERSI

                }, KEY_BR_NO + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);               //YOU MAY NEED TO ADD ONE MORE NULL

        Product contact = null;

        if (cursor != null && cursor.moveToFirst()) {
            contact = new Product(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)
                    ,cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12)
                    ,cursor.getString(13),cursor.getString(14),cursor.getString(15),cursor.getString(16),cursor.getString(17),cursor.getString(18));
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
                    product.setCal(cursor.getString(4));
                    product.set_tofat(cursor.getString(5));
                    product.set_sfat(cursor.getString(6));
                    product.set_trfat(cursor.getString(7));

                    product.set_chole(cursor.getString(8));
                    product.set_sodiu(cursor.getString(9));
                    product.set_carbs(cursor.getString(10));
                    product.set_diefi(cursor.getString(11));
                    product.set_sugr(cursor.getString(12));
                    product.set_prote(cursor.getString(13));
                    product.set_vitd(cursor.getString(14));
                    product.set_calc(cursor.getString(15));
                    product.set_iron(cursor.getString(16));
                    product.set_potas(cursor.getString(17));
                    product.set_sersi(cursor.getString(18));
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
        values.put(KEY_CAL, contact.getCal());
        values.put(KEY_TOFAT, contact.get_tofat());
        values.put(KEY_SFAT, contact.get_sfat());
        values.put(KEY_TRFAT, contact.get_trfat());

        values.put(KEY_CHOLE, contact.get_chole());
        values.put(KEY_SODIU, contact.get_sodiu());
        values.put(KEY_CARBS, contact.get_carbs());
        values.put(KEY_DIEFI, contact.get_diefi());
        values.put(KEY_SUGR, contact.get_sugr());
        values.put(KEY_PROTE, contact.get_prote());
        values.put(KEY_VITD, contact.get_vitd());
        values.put(KEY_CALC, contact.get_calc());
        values.put(KEY_IRON, contact.get_iron());
        values.put(KEY_POTAS, contact.get_potas());
        values.put(KEY_SERSI, contact.get_sersi());

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
