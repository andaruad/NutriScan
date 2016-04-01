package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


// Created by Andaruad on 22/02/2016.

public class CompareMain extends Activity {
Product product = this.product;


    String result1;
    long resultx1;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_main);

        DBHandler dbHandler = new DBHandler(this);
        result1 = getIntent().getStringExtra("barcode_num1");
        resultx1 = Long.parseLong(getIntent().getStringExtra("barcode_num1"));
        Product product = dbHandler.Get_Bar(resultx1);

        if(product == null ){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "The product you scanned exist in the Database", Toast.LENGTH_LONG);
            toast.show();

        } else{
            new AlertDialog.Builder(this)
                    .setTitle("Product Not Available")
                    .setMessage("Do you want to add product")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }

        ImageButton rescan = (ImageButton) findViewById(R.id.brescan);
        rescan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(CompareMain.this);
                integrator.initiateScan();
            }});

        ImageButton compare = (ImageButton) findViewById(R.id.bcompare2);
        compare.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(CompareMain.this);
                integrator.initiateScan();
            }});


        TextView tv =(TextView) findViewById(R.id.tvresult2);
        tv.setText("   "+result1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode,resultCode, intent);
        if (scanResult != null){
            String re2 = scanResult.getContents();
            //re = scanResult.getContents();
            Log.d("code", re2);
//                if(re != null){
//                    StoreValue value =  (StoreValue) StoreValue.setValue1(re);
//
//                }


            TextView tvresult3 = (TextView) findViewById(R.id.tvresult3);
            tvresult3.setText(re2);
            Intent compare = new Intent(this, CompareFinal.class);
            compare.putExtra("barcode_num2", re2);
            startActivity(compare);
        }else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_LONG);
            toast.show();
        }
    }







}
