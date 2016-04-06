package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

//Created by Andaruad on 27/03/2016.

public class CompareFinal extends Activity{
TextView barcodeF1, barcodeF2;
String result1, result2;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_final);

        result1 = getIntent().getStringExtra("barcode_num1");
        barcodeF1 =(TextView)findViewById(R.id.barcodeF1);
        barcodeF1.setText(result1);
        result2 = getIntent().getStringExtra("barcode_num2");
        barcodeF2 =(TextView)findViewById(R.id.barcodeF2);
        barcodeF2.setText(result2);


    }
}
