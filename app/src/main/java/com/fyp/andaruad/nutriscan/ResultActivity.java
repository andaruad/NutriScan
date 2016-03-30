package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

/*
 * Created by Andaruad on 16/02/2016.
 */
public class ResultActivity extends Activity {

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_main);
        TextView pname = (TextView)findViewById(R.id.pname);
        TextView cal = (TextView)findViewById(R.id.calories);
        DBHandler dbHandler = new DBHandler(this);
        long productid  = getIntent().getLongExtra("productid", 0);
        Product product = dbHandler.Get_Product(productid);


        if(product != null){
            pname.setText(product.getName());
            cal.setText(product.getCal());
        } else {
            pname.setText("Product not found");
        }
    }




}
