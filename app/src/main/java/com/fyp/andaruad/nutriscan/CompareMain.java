package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


//  Created by Andaruad on 22/02/2016.

public class CompareMain extends Activity  {

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_main);
    }
    TextView tvresult = (TextView) findViewById(R.id.tvresult2);
    //tvresult.setText("Your scanned barcode is: ", re);

    }


