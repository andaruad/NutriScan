package com.fyp.andaruad.nutriscan;

import android.app.Activity;
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


    String result1;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_main);

        result1 = getIntent().getStringExtra("barcode_num1");

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
        tv.setText(result1);
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
