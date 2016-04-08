package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*
 * Created by Andaruad on 16/02/2016.
 */
public class ResultActivity extends Activity {

    long divider;
    long parse;
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
        TextView sersi = (TextView)findViewById(R.id.serve);
        TextView tofat2 = (TextView)findViewById(R.id.tofat2);
        TextView sfat2 = (TextView)findViewById(R.id.sfat2);
        TextView trfat2 = (TextView)findViewById(R.id.trfat2);
        TextView chloe2 = (TextView)findViewById(R.id.chloe2);
        TextView sodiu2 = (TextView)findViewById(R.id.sodiu2);
        TextView carbs2 = (TextView)findViewById(R.id.carbs2);
        TextView diefi2 = (TextView)findViewById(R.id.diefi2);
        TextView sugr2 = (TextView)findViewById(R.id.sugr2);
        TextView prote2 = (TextView)findViewById(R.id.protei2);
        TextView vitd2 = (TextView)findViewById(R.id.vitd2);
        TextView calc2 = (TextView)findViewById(R.id.calc2);
        TextView iron2 = (TextView)findViewById(R.id.iron2);
        TextView potas2 = (TextView)findViewById(R.id.potas2);


        DBHandler dbHandler = new DBHandler(this);
        long productid  = getIntent().getLongExtra("productid", 0);
        Product product = dbHandler.Get_Product(productid);


        if(product != null){
            pname.setText(product.getName());
            cal.setText(product.getCal());
            int cals = (Integer.parseInt(product.getCal().toString()));
            int divider = 100/(Integer.parseInt(product.get_sersi().toString()));

            cal2.setText((Integer.parseInt(product.getCal().toString()))/divider+"");
            tofat2.setText((Integer.parseInt(product.get_tofat().toString()))/divider+"");
            tofat.setText(product.get_tofat());
            sfat2.setText((Integer.parseInt(product.get_sfat().toString()))/divider+"");
            sfat.setText(product.get_sfat());
            trfat2.setText((Integer.parseInt(product.get_trfat().toString())) / divider + "");
            trfat.setText(product.get_trfat());
            chloe2.setText((Integer.parseInt(product.get_chole().toString()))/divider+"");
            chloe.setText(product.get_chole());
            sodiu2.setText((Integer.parseInt(product.get_sodiu().toString()))/divider+"");
            sodiu.setText(product.get_sodiu());
            carbs2.setText((Integer.parseInt(product.get_carbs().toString()))/divider+"");
            carbs.setText(product.get_carbs());
            diefi2.setText((Integer.parseInt(product.get_diefi().toString()))/divider+"");
            diefi.setText(product.get_diefi());
            sugr2.setText((Integer.parseInt(product.get_sugr().toString()))/divider+"");
            sugr.setText(product.get_sugr());
            prote2.setText((Integer.parseInt(product.get_prote().toString())) / divider + "");
            prote.setText(product.get_prote());
            vitd2.setText((Integer.parseInt(product.get_vitd().toString()))/divider+"");
            vitd.setText(product.get_vitd());
            calc2.setText((Integer.parseInt(product.get_calc().toString()))/divider+"");
            calc.setText(product.get_calc());
            iron2.setText((Integer.parseInt(product.get_iron().toString()))/divider+"");
            iron.setText(product.get_iron());
            potas2.setText((Integer.parseInt(product.get_potas().toString()))/divider+"");
            potas.setText(product.get_potas());
            barcode.setText(product.getBarcodeNumber());
            sersi.setText(product.get_sersi());

        } else {
            pname.setText("Product not found");
        }
    }



}
