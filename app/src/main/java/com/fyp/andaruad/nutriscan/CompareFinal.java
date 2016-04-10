package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

//Created by Andaruad on 27/03/2016.

public class CompareFinal extends Activity{
TextView barcodeF1, barcodeF2;
String result1, result2;
long resultx1,resultx2;
Product product1, product2;
DBHandler dbHandler;
Toast toastz;
TextView calori2,sersi2, pname2, cate2, tfat2, sfat2,trfat2, chloe2, sodiu2, carbs2, diefi2, sugar2, protein2, vitd2, calc2, iron2, potas2;
TextView calori1,sersi1, pname1, cate1, tfat1, sfat1,trfat1, chloe1, sodiu1, carbs1, diefi1, sugar1, protein1, vitd1, calc1, iron1, potas1;
TextView calori3,sersi3, pname3, cate3, tfat3, sfat3,trfat3, chloe3, sodiu3, carbs3, diefi3, sugar3, protein3, vitd3, calc3, iron3, potas3;
TextView calori4,sersi4, pname4, cate4, tfat4, sfat4,trfat4, chloe4, sodiu4, carbs4, diefi4, sugar4, protein4, vitd4, calc4, iron4, potas4;
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
        product1 = dbHandler.Get_Bar(resultx1);
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
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "The product you scanned exist in the Database", Toast.LENGTH_SHORT);
//            toast.show();

            TVholder();
            Calculation();




    }
        //Display

    }
    public void Calculation()   {

        int point1 = 1;
        int point2 = 1;
        if((Integer.parseInt(product1.get_tofat().toString())) > (Integer.parseInt(product2.get_tofat().toString())))
        {   point1 += 1;}
        else if((Integer.parseInt(product2.get_tofat().toString())) > (Integer.parseInt(product1.get_tofat().toString())))
        { point2 += 1;}
        System.out.println(point1);
        System.out.println(point2);



        if((Integer.parseInt(product1.get_chole().toString())) > (Integer.parseInt(product2.get_chole().toString())))
        {   point1 += 1;}
        else if((Integer.parseInt(product2.get_chole().toString())) > (Integer.parseInt(product1.get_chole().toString())))
        { point2 += 1;}
        System.out.println(point1);
        System.out.println(point2);


        if((Integer.parseInt(product1.get_sodiu().toString())) > (Integer.parseInt(product2.get_sodiu().toString())))
        {   point1 += 1;}
        else if((Integer.parseInt(product2.get_sodiu().toString())) > (Integer.parseInt(product1.get_sodiu().toString())))
        { point2 += 1;}
        System.out.println(point1);
        System.out.println(point2);

        if((Integer.parseInt(product1.get_sugr().toString())) > (Integer.parseInt(product2.get_sugr().toString())))
        {   point1 += 1;}
        else if((Integer.parseInt(product2.get_sugr().toString())) > (Integer.parseInt(product1.get_sugr().toString())))
        { point2 += 1;}
        System.out.println(point1);
        System.out.println(point2);


        if((Integer.parseInt(product1.get_prote().toString())) > (Integer.parseInt(product2.get_prote().toString())))
        {   point1 -= 1;}
        else if((Integer.parseInt(product2.get_prote().toString())) > (Integer.parseInt(product1.get_prote().toString())))
        { point2 -= 1;}
        System.out.println(point1);
        System.out.println(point2);

        if((Integer.parseInt(product1.get_diefi().toString())) > (Integer.parseInt(product2.get_diefi().toString())))
        {   point1 -= 1;}
        else if((Integer.parseInt(product2.get_diefi().toString())) > (Integer.parseInt(product1.get_diefi().toString())))
        { point2 -= 1;}
        System.out.println(point1);
        System.out.println(point2);

        if (point1>point2){


            TextView recommend = (TextView)findViewById(R.id.recommend);
            recommend.setText("We Recommend: " + product1.getName() );
        }
        if (point2>point1){


            TextView recommend = (TextView)findViewById(R.id.recommend);
            recommend.setText("We Recommend: " + product2.getName());
        }
        if(point1==point2){
            TextView recommend = (TextView)findViewById(R.id.recommend);
            recommend.setText("The Product is equal");
        }




    }

    public void TVholder(){
        barcodeF1 =(TextView)findViewById(R.id.barcodeF1);
        barcodeF1.setText(result1);
        barcodeF2 =(TextView)findViewById(R.id.barcodeF2);
        barcodeF2.setText(result2);
        pname2 = (TextView)findViewById(R.id.pname2);
        pname2.setText(product2.getName());
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



        pname1 = (TextView)findViewById(R.id.pname1);
        pname1.setText(product1.getName());
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

        int divider1 = 100/(Integer.parseInt(product1.get_sersi().toString()));
        calori3 = (TextView) findViewById(R.id.calB1);
        calori3.setText((Integer.parseInt(product1.getCal().toString()))/divider1+"");
        tfat3= (TextView)findViewById(R.id.tofatB1);
        tfat3.setText((Integer.parseInt(product1.get_tofat().toString()))/divider1+"");
        sfat3= (TextView)findViewById(R.id.sfatB1);
        sfat3.setText((Integer.parseInt(product1.get_sfat().toString()))/divider1+"");
        trfat3= (TextView)findViewById(R.id.trfatB1);
        trfat3.setText((Integer.parseInt(product1.get_trfat().toString()))/divider1+"");
        chloe3= (TextView)findViewById(R.id.chloeB1);
        chloe3.setText((Integer.parseInt(product1.get_chole().toString()))/divider1+"");
        sodiu3= (TextView)findViewById(R.id.sodiuB1);
        sodiu3.setText((Integer.parseInt(product1.get_sodiu().toString()))/divider1+"");
        carbs3= (TextView)findViewById(R.id.carbsB1);
        carbs3.setText((Integer.parseInt(product1.get_carbs().toString()))/divider1+"");
        diefi3= (TextView)findViewById(R.id.diefiB1);
        diefi3.setText((Integer.parseInt(product1.get_diefi().toString()))/divider1+"");
        sugar3= (TextView)findViewById(R.id.sugarB1);
        sugar3.setText((Integer.parseInt(product1.get_sugr().toString()))/divider1+"");
        protein3= (TextView)findViewById(R.id.proteiB1);
        protein3.setText((Integer.parseInt(product1.get_prote().toString()))/divider1+"");
        vitd3= (TextView)findViewById(R.id.vitdB1);
        vitd3.setText((Integer.parseInt(product1.get_vitd().toString()))/divider1+"");
        calc3= (TextView)findViewById(R.id.calcB1);
        calc3.setText((Integer.parseInt(product1.get_calc().toString()))/divider1+"");
        iron3= (TextView)findViewById(R.id.ironB1);
        iron3.setText((Integer.parseInt(product1.get_iron().toString()))/divider1+"");
        potas3= (TextView)findViewById(R.id.potasB1);
        potas3.setText((Integer.parseInt(product1.get_potas().toString()))/divider1+"");

        int divider2 = 100/(Integer.parseInt(product2.get_sersi().toString()));
        calori4 = (TextView) findViewById(R.id.calB2);
        calori4.setText((Integer.parseInt(product2.getCal().toString()))/divider2+"");
        tfat4= (TextView)findViewById(R.id.tofatB2);
        tfat4.setText((Integer.parseInt(product2.get_tofat().toString()))/divider2+"");
        sfat4= (TextView)findViewById(R.id.sfatB2);
        sfat4.setText((Integer.parseInt(product2.get_sfat().toString()))/divider2+"");
        trfat4= (TextView)findViewById(R.id.trfatB2);
        trfat4.setText((Integer.parseInt(product2.get_trfat().toString()))/divider2+"");
        chloe4= (TextView)findViewById(R.id.chloeB2);
        chloe4.setText((Integer.parseInt(product2.get_chole().toString()))/divider2+"");
        sodiu4= (TextView)findViewById(R.id.sodiuB2);
        sodiu4.setText((Integer.parseInt(product2.get_sodiu().toString()))/divider2+"");
        carbs4= (TextView)findViewById(R.id.carbsB2);
        carbs4.setText((Integer.parseInt(product2.get_carbs().toString()))/divider2+"");
        diefi4= (TextView)findViewById(R.id.diefiB2);
        diefi4.setText((Integer.parseInt(product2.get_diefi().toString()))/divider2+"");
        sugar4= (TextView)findViewById(R.id.sugarB2);
        sugar4.setText((Integer.parseInt(product2.get_sugr().toString()))/divider2+"");
        protein4= (TextView)findViewById(R.id.proteiB2);
        protein4.setText((Integer.parseInt(product2.get_prote().toString()))/divider2+"");
        vitd4= (TextView)findViewById(R.id.vitdB2);
        vitd4.setText((Integer.parseInt(product2.get_vitd().toString()))/divider2+"");
        calc4= (TextView)findViewById(R.id.calcB2);
        calc4.setText((Integer.parseInt(product2.get_calc().toString()))/divider2+"");
        iron4= (TextView)findViewById(R.id.ironB2);
        iron4.setText((Integer.parseInt(product2.get_iron().toString()))/divider2+"");
        potas4= (TextView)findViewById(R.id.potasB2);
        potas4.setText((Integer.parseInt(product2.get_potas().toString())) / divider2 + "");


    }

}
