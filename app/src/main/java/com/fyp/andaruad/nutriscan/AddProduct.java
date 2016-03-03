package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

// Created by Andaruad on 25/02/2016.
public class AddProduct extends Activity {

EditText inproductbarcodeET;
TextView inproductbarcodeTV;
DBHandler dbHandler;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.addproduct_main);
//        inproductbarcodeET = (EditText) findViewById(R.id.etresult);
//        inproductbarcodeTV = (TextView) findViewById(R.id.tvresult);
        dbHandler = new DBHandler (this, null, null, 1);
        printDatabase();
    }

    public void addButtonClicked(){
        ProductsDB productsDB = new ProductsDB(inproductbarcodeET.getText().toString());
        dbHandler.addProduct(productsDB);
        printDatabase();
    }

    public void delButtonClicked(){
        String inputText = inproductbarcodeET.getText().toString();
        dbHandler.delProduct(inputText);
        printDatabase();

    }

    public void printDatabase(){
        String dbString = dbHandler.databasetoString();
        inproductbarcodeTV.setText(dbString);
        inproductbarcodeET.setText("");
    }
}
