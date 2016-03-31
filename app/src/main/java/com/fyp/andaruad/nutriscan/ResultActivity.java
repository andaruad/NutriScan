package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import java.math.*;
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
        TextView cal2 = (TextView)findViewById(R.id.calories2);
        TextView tofat = (TextView)findViewById(R.id.tofat);
        TextView sfat = (TextView)findViewById(R.id.sfat);
        TextView trfat = (TextView)findViewById(R.id.trfat);
        TextView chloe = (TextView)findViewById(R.id.chloe);
        TextView sodiu = (TextView)findViewById(R.id.sodiu);
        TextView carbs = (TextView)findViewById(R.id.carbs);
        TextView diefi = (TextView)findViewById(R.id.diefi);
        TextView sugr = (TextView)findViewById(R.id.sugr);
        TextView prote = (TextView)findViewById(R.id.prote);
        TextView vitd = (TextView)findViewById(R.id.vitd);
        TextView calc = (TextView)findViewById(R.id.calc);
        TextView iron = (TextView)findViewById(R.id.iron);
        TextView potas = (TextView)findViewById(R.id.potas);
        TextView barcode = (TextView)findViewById(R.id.barcode);
//        TextView tofat2 = (TextView)findViewById(R.id.calories2);


        DBHandler dbHandler = new DBHandler(this);
        long productid  = getIntent().getLongExtra("productid", 0);
        Product product = dbHandler.Get_Product(productid);


        if(product != null){
            pname.setText(product.getName());
            cal.setText(product.getCal());
            int cals = (Integer.parseInt(product.getCal().toString())/2);
            cal2.setText(cals+"");
            tofat.setText(product.get_tofat());
            sfat.setText(product.get_sfat());
            trfat.setText(product.get_trfat());
            chloe.setText(product.get_chole());
            sodiu.setText(product.get_sodiu());
            carbs.setText(product.get_carbs());
            diefi.setText(product.get_diefi());
            sugr.setText(product.get_sugr());
            prote.setText(product.get_prote());
            vitd.setText(product.get_vitd());
            calc.setText(product.get_calc());
            iron.setText(product.get_iron());
            potas.setText(product.get_potas());
            barcode.setText(product.getBarcodeNumber());

        } else {
            pname.setText("Product not found");
        }
    }



}
