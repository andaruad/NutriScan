package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

//Created by Andaruad on 27/03/2016.

public class CompareFinal extends Activity{
TextView barcodeF1, barcodeF2;
String result1, result2;
long resultx1,resultx2;
Product product1, product2;
DBHandler dbHandler;
TextView calori2,sersi2, pname2, cate2, tfat2, sfat2,trfat2, chloe2, sodiu2, carbs2, diefi2, sugar2, protein2, vitd2, calc2, iron2, potas2;
TextView calori1,sersi1, pname1, cate1, tfat1, sfat1,trfat1, chloe1, sodiu1, carbs1, diefi1, sugar1, protein1, vitd1, calc1, iron1, potas1;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_final);

        DBHandler dbHandler = new DBHandler(this);
        result1 = getIntent().getStringExtra("barcode_num1");
        resultx1 = Long.parseLong(getIntent().getStringExtra("barcode_num1"));
        result2 = getIntent().getStringExtra("barcode_num2");
        resultx2 = Long.parseLong(getIntent().getStringExtra("barcode_num2"));
        product2 = dbHandler.Get_Bar(resultx2);
        if(product2 == null ){
            new AlertDialog.Builder(this)
                    .setTitle("Product Not Available")
                    .setMessage("Do you want to add product")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), Testing.class);
                            startActivity(intent);
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();

        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "The product you scanned exist in the Database", Toast.LENGTH_LONG);
            toast.show();
            calori2 = (TextView) findViewById(R.id.calA2);
            calori2.setText(product2.getCal());
            tfat2= (TextView)findViewById(R.id.tofatA2);
            tfat2.setText(product2.get_tofat());
            sfat2= (TextView)findViewById(R.id.sfatA2);
            sfat2.setText(product2.get_sfat());
            trfat2= (TextView)findViewById(R.id.trfatA2);
            trfat2.setText(product2.get_trfat());
            chloe2= (TextView)findViewById(R.id.chloeA2);
            chloe2.setText(product2.get_chole());
            sodiu2= (TextView)findViewById(R.id.sodiuA2);
            sodiu2.setText(product2.get_sodiu());
            carbs2= (TextView)findViewById(R.id.carbsA2);
            carbs2.setText(product2.get_carbs());
            diefi2= (TextView)findViewById(R.id.diefiA2);
            diefi2.setText(product2.get_diefi());
            sugar2= (TextView)findViewById(R.id.sugarA2);
            sugar2.setText(product2.get_sugr());
            protein2= (TextView)findViewById(R.id.proteiA2);
            protein2.setText(product2.get_prote());
            vitd2= (TextView)findViewById(R.id.vitdA2);
            vitd2.setText(product2.get_vitd());
            calc2= (TextView)findViewById(R.id.calcA2);
            calc2.setText(product2.get_calc());
            iron2= (TextView)findViewById(R.id.ironA2);
            iron2.setText(product2.get_iron());
            potas2= (TextView)findViewById(R.id.potasA2);
            potas2.setText(product2.get_potas());


            product1 = dbHandler.Get_Bar(resultx1);
            calori1 = (TextView) findViewById(R.id.calA1);
            calori1.setText(product1.getCal());
            tfat1= (TextView)findViewById(R.id.tofatA1);
            tfat1.setText(product1.get_tofat());
            sfat1= (TextView)findViewById(R.id.sfatA1);
            sfat1.setText(product1.get_sfat());
            trfat1= (TextView)findViewById(R.id.trfatA1);
            trfat1.setText(product1.get_trfat());
            chloe1= (TextView)findViewById(R.id.chloeA1);
            chloe1.setText(product1.get_chole());
            sodiu1= (TextView)findViewById(R.id.sodiuA1);
            sodiu1.setText(product1.get_sodiu());
            carbs1= (TextView)findViewById(R.id.carbsA1);
            carbs1.setText(product1.get_carbs());
            diefi1= (TextView)findViewById(R.id.diefiA1);
            diefi1.setText(product1.get_diefi());
            sugar1= (TextView)findViewById(R.id.sugarA1);
            sugar1.setText(product1.get_sugr());
            protein1= (TextView)findViewById(R.id.proteiA1);
            protein1.setText(product1.get_prote());
            vitd1= (TextView)findViewById(R.id.vitdA1);
            vitd1.setText(product1.get_vitd());
            calc1= (TextView)findViewById(R.id.calcA1);
            calc1.setText(product1.get_calc());
            iron1= (TextView)findViewById(R.id.ironA1);
            iron1.setText(product1.get_iron());
            potas1= (TextView)findViewById(R.id.potasA1);
            potas1.setText(product1.get_potas());
        }









        //Display
        barcodeF1 =(TextView)findViewById(R.id.barcodeF1);
        barcodeF1.setText(result1);
        barcodeF2 =(TextView)findViewById(R.id.barcodeF2);
        barcodeF2.setText(result2);
    }
}
