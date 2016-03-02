package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.zxing.integration.android.IntentIntegrator;


//* Created by Andaruad on 22/02/2016.

public class CompareMain extends Activity {

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_main);

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




    }










}
