package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.zxing.integration.android.IntentIntegrator;


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










}
