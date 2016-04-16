package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


// Created by Andaruad on 22/02/2016.

public class CompareMain extends Activity {

    Product product;
    String result1, diettypes;
    long resultx1;
    TextView calori,sersi, pname, cate, tfat, sfat,trfat, chloe, sodiu, carbs, diefi, sugar, protein, vitd, calc, iron, potas;
    TextView calori2,sersi2, pname2, cate2, tfat2, sfat2,trfat2, chloe2, sodiu2, carbs2, diefi2, sugar2, protein2, vitd2, calc2, iron2, potas2;
    double zpoint2,zhsr2, zcal2, zsfat2, zsugr2, zsodiu2,zpro2, zdiefi2;
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_main);

        DBHandler dbHandler = new DBHandler(this);
        result1 = getIntent().getStringExtra("barcode_num1");
        diettypes = getIntent().getStringExtra("diet");
        resultx1 = Long.parseLong(getIntent().getStringExtra("barcode_num1"));
       diettypes = getIntent().getStringExtra("diet");
        product = dbHandler.Get_Bar(resultx1);

        if(product == null ){
            new AlertDialog.Builder(this)
                    .setTitle("Product Not Available")
                    .setMessage("Do you want to add product")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), Addlist.class);
                            startActivity(intent);
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();

        } else{

            Toast toast = Toast.makeText(getApplicationContext(),
                    "The product you scanned exist in the Database "+DietTypes.choice, Toast.LENGTH_LONG);
            toast.show();
            TVHolder();


        }

        ImageButton rescan = (ImageButton) findViewById(R.id.brescan);
        rescan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(CompareMain.this);
                integrator.initiateScan();
            }});

        ImageButton compare = (ImageButton) findViewById(R.id.bcompare2);
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(CompareMain.this);
                integrator.initiateScan();
            }
        });

        getIntent().getSerializableExtra("diet");
        TextView tv =(TextView) findViewById(R.id.tvresult2);
        tv.setText("   " + result1);

        Calculation2();

        ImageView recommend = (ImageView)findViewById(R.id.imageView2);
        if (zhsr2==0.5){
            recommend.setImageResource(R.drawable.half);
        }
        if (zhsr2==1){
            recommend.setImageResource(R.drawable.one);
        }
        if (zhsr2==1.5){
            recommend.setImageResource(R.drawable.onehalf);
        }
        if (zhsr2==2){
            recommend.setImageResource(R.drawable.two);
        }
        if (zhsr2==2.5){
            recommend.setImageResource(R.drawable.twohalf);
        }
        if (zhsr2==3){
            recommend.setImageResource(R.drawable.three);
        }
        if (zhsr2==3.5){
            recommend.setImageResource(R.drawable.threehalf);
        }
        if (zhsr2==4){
            recommend.setImageResource(R.drawable.four);
        }
        if (zhsr2==4.5){
            recommend.setImageResource(R.drawable.fourhalf);
        }
        if (zhsr2==5){
            recommend.setImageResource(R.drawable.five);
        }

//        System.out.println(product.getCate());

//        TextView checked = (TextView)findViewById(diettypes)

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode,resultCode, intent);
        if (scanResult != null){
            String re2 = scanResult.getContents();
            Intent compare2final = new Intent(this, CompareFinal.class);
            compare2final.putExtra("barcode_num1",result1);
            compare2final.putExtra("barcode_num2", re2);
            startActivity(compare2final);
        }else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_LONG);
            toast.show();
        }
    }


    public void TVHolder(){
        calori = (TextView) findViewById(R.id.caloriessmall);
        calori.setText(product.getCal()+" kJ");
        pname = (TextView) findViewById(R.id.pname1);
        pname.setText(product.getName());
        tfat= (TextView)findViewById(R.id.tofatsmall);
        tfat.setText(product.get_tofat()+" g");
        sfat= (TextView)findViewById(R.id.sfatsmall);
        sfat.setText(product.get_sfat()+" g");
        trfat= (TextView)findViewById(R.id.trfatsmall);
        trfat.setText(product.get_trfat()+" g");
        chloe= (TextView)findViewById(R.id.chloesmall);
        chloe.setText(product.get_chole()+" mg");
        sodiu= (TextView)findViewById(R.id.sodiusmall);
        sodiu.setText(product.get_sodiu()+" mg");
        carbs= (TextView)findViewById(R.id.carbssmall);
        carbs.setText(product.get_carbs()+" g");
        diefi= (TextView)findViewById(R.id.diefismall);
        diefi.setText(product.get_diefi()+" mg");
        sugar= (TextView)findViewById(R.id.sugrsmall);
        sugar.setText(product.get_sugr()+" mg");
        protein= (TextView)findViewById(R.id.protesmall);
        protein.setText(product.get_prote()+" g");
        vitd= (TextView)findViewById(R.id.vitdsmall);
        vitd.setText(product.get_vitd()+" mg");
        calc= (TextView)findViewById(R.id.calcsmall);
        calc.setText(product.get_calc()+" mg");
        iron= (TextView)findViewById(R.id.ironsmall);
        iron.setText(product.get_iron()+" mg");
        potas= (TextView)findViewById(R.id.potassmall);
        potas.setText(product.get_potas()+" mg");
        sersi=(TextView)findViewById(R.id.servesmall);
        sersi.setText("  "+ product.get_sersi()+" g");

        int divider = 100/(Integer.parseInt(product.get_sersi().toString()));
        calori2 = (TextView) findViewById(R.id.caloriessmall2);
        calori2.setText((Integer.parseInt(product.getCal().toString()))/divider+" kJ");
        tfat2= (TextView)findViewById(R.id.tofatsmall2);
        tfat2.setText((Integer.parseInt(product.get_tofat().toString()))/divider+" g");
        sfat2= (TextView)findViewById(R.id.sfatsmall2);
        sfat2.setText((Integer.parseInt(product.get_sfat().toString()))/divider+" g");
        trfat2= (TextView)findViewById(R.id.trfatsmall2);
        trfat2.setText((Integer.parseInt(product.get_trfat().toString()))/divider+" g");
        chloe2= (TextView)findViewById(R.id.chloesmall2);
        chloe2.setText((Integer.parseInt(product.get_chole().toString()))/divider+" mg");
        sodiu2= (TextView)findViewById(R.id.sodiusmall2);
        sodiu2.setText((Integer.parseInt(product.get_sodiu().toString()))/divider+" mg");
        carbs2= (TextView)findViewById(R.id.carbssmall2);
        carbs2.setText((Integer.parseInt(product.get_carbs().toString()))/divider+" g");
        diefi2= (TextView)findViewById(R.id.diefismall2);
        diefi2.setText((Integer.parseInt(product.get_diefi().toString()))/divider+" mg");
        sugar2= (TextView)findViewById(R.id.sugrsmall2);
        sugar2.setText(((Integer.parseInt(product.get_sugr().toString()))/divider+" g"));
        protein2= (TextView)findViewById(R.id.protesmall2);
        protein2.setText((Integer.parseInt(product.get_prote().toString()))/divider+" g");
        vitd2= (TextView)findViewById(R.id.vitdsmall2);
        vitd2.setText((Integer.parseInt(product.get_vitd().toString()))/divider+" mg");
        calc2= (TextView)findViewById(R.id.calcsmall2);
        calc2.setText((Integer.parseInt(product.get_calc().toString()))/divider+" mg");
        iron2= (TextView)findViewById(R.id.ironsmall2);
        iron2.setText((Integer.parseInt(product.get_iron().toString()))/divider+" mg");
        potas2= (TextView)findViewById(R.id.potassmall2);
        potas2.setText((Integer.parseInt(product.get_potas().toString()))/divider+" mg");
    }

    public void Calculation2(){

//Calories in KJ
        if(Integer.parseInt(product.getCal())<=335){
            zcal2=0;
        }
        if(Integer.parseInt(product.getCal())>335){
            zcal2=1;
        }
        if(Integer.parseInt(product.getCal())>670){
            zcal2=2;
        }
        if(Integer.parseInt(product.getCal())>1005){
            zcal2=3;
        }
        if(Integer.parseInt(product.getCal())>1340){
            zcal2=4;
        }
        if(Integer.parseInt(product.getCal())>1675){
            zcal2=5;
        }
        if(Integer.parseInt(product.getCal())>2010){
            zcal2=6;
        }
        if(Integer.parseInt(product.getCal())>2345){
            zcal2=7;
        }
        if(Integer.parseInt(product.getCal())>2680){
            zcal2=8;
        }
        if(Integer.parseInt(product.getCal())>3015){
            zcal2=9;
        }
        if(Integer.parseInt(product.getCal())>3350){
            zcal2=10;
        }
        if(Integer.parseInt(product.getCal())>3686){
            zcal2=11;
        }


        System.out.println("zcal2: "+zcal2);

//Saturated Fat
        if(Integer.parseInt(product.get_sfat())<1){
            zsfat2=0;
        }
        if(Integer.parseInt(product.get_sfat())>=1){
            zsfat2=1;
        }
        if(Integer.parseInt(product.get_sfat())>=2){
            zsfat2=2;
        }
        if(Integer.parseInt(product.get_sfat())>=3){
            zsfat2=3;
        }
        if(Integer.parseInt(product.get_sfat())>=4){
            zsfat2=4;
        }
        if(Integer.parseInt(product.get_sfat())>=5){
            zsfat2=5;
        }
        if(Double.parseDouble(product.get_sfat())>=6){
            zsfat2=6;
        }
        if(Double.parseDouble(product.get_sfat())>=7){
            zsfat2=7;
        }
        if(Double.parseDouble(product.get_sfat())>=8){
            zsfat2=8;
        }
        if(Double.parseDouble(product.get_sfat())>=9){
            zsfat2=9;
        }
        if(Double.parseDouble(product.get_sfat())>=10.0){
            zsfat2=10;
        }
        if(Double.parseDouble(product.get_sfat())>=11.2){
            zsfat2=11;
        }
        if(Double.parseDouble(product.get_sfat())>=12.5){
            zsfat2=12;
        }
        if(Double.parseDouble(product.get_sfat())>=13.9){
            zsfat2=13;
        }
        if(Integer.parseInt(product.get_sfat())>=15.5){
            zsfat2=14;
        }
        if(Double.parseDouble(product.get_sfat())>=17.3){
            zsfat2=15;
        }
        if(Double.parseDouble(product.get_sfat())>=19.3){
            zsfat2=16;
        }
        if(Double.parseDouble(product.get_sfat())>=21.6){
            zsfat2=17;
        }
        if(Double.parseDouble(product.get_sfat())>=24.1){
            zsfat2=18;
        }

        System.out.println("zsfat2: "+ zsfat2);


        if(Double.parseDouble(product.get_sugr())<=5){
            zsugr2 =0;
        }
        if(Double.parseDouble(product.get_sugr())>5){
            zsugr2=1;
        }
        if(Integer.parseInt(product.get_sugr())>9){
            zsugr2 =2;
        }
        if(Double.parseDouble(product.get_sugr())>13.5){
            zsugr2=3;
        }
        if(Double.parseDouble(product.get_sugr())>18){
            zsugr2 =4;
        }
        if(Double.parseDouble(product.get_sugr())>22.5){
            zsugr2 =5;
        }
        if(Double.parseDouble(product.get_sugr())>27){
            zsugr2=6;
        }
        if(Integer.parseInt(product.get_sugr())>31){
            zsugr2 =7;
        }
        if(Integer.parseInt(product.get_sugr())>36){
            zsugr2=8;
        }
        if(Integer.parseInt(product.get_sugr())>40){
            zsugr2 =9;
        }
        if(Double.parseDouble(product.get_sugr())>45){
            zsugr2 =10;
        }
        if(Double.parseDouble(product.get_sugr())>49){
            zsugr2=11;
        }
        if(Integer.parseInt(product.get_sugr())>54){
            zsugr2 =12;
        }
        if(Integer.parseInt(product.get_sugr())>58){
            zsugr2=13;
        }
        if(Integer.parseInt(product.get_sugr())>63){
            zsugr2 =14;
        }
        if(Double.parseDouble(product.get_sugr())>67){
            zsugr2 =15;
        }
        if(Double.parseDouble(product.get_sugr())>72){
            zsugr2=16;
        }
        if(Integer.parseInt(product.get_sugr())>76){
            zsugr2 =17;
        }
        if(Integer.parseInt(product.get_sugr())>81){
            zsugr2=18;
        }
        if(Integer.parseInt(product.get_sugr())>85){
            zsugr2 =19;
        }
        if(Double.parseDouble(product.get_sugr())>90){
            zsugr2 =20;
        }
        if(Double.parseDouble(product.get_sugr())>94){
            zsugr2=21;
        }
        if(Integer.parseInt(product.get_sugr())>99){
            zsugr2 =22;
        }





        System.out.println("zsugr2: "+zsugr2);


        if(Double.parseDouble(product.get_sodiu())<=90){
            zsodiu2 =0;
        }
        if(Integer.parseInt(product.get_sodiu())>90){
            zsodiu2=1;
        }
        if(Integer.parseInt(product.get_sodiu())>180){
            zsodiu2 =2;
        }
        if(Integer.parseInt(product.get_sodiu())>270){
            zsodiu2=3;
        }
        if(Integer.parseInt(product.get_sodiu())>360){
            zsodiu2 =4;
        }
        if(Double.parseDouble(product.get_sodiu())>450){
            zsodiu2 =5;
        }
        if(Double.parseDouble(product.get_sodiu())>540){
            zsodiu2 =6;
        }
        if(Integer.parseInt(product.get_sodiu())>630){
            zsodiu2=7;
        }
        if(Integer.parseInt(product.get_sodiu())>720){
            zsodiu2 =8;
        }
        if(Integer.parseInt(product.get_sodiu())>810){
            zsodiu2=9;
        }
        if(Integer.parseInt(product.get_sodiu())>900){
            zsodiu2 =10;
        }
        if(Double.parseDouble(product.get_sodiu())>1005){
            zsodiu2 =11;
        }
        if(Integer.parseInt(product.get_sodiu())>1121){
            zsodiu2=12;
        }
        if(Integer.parseInt(product.get_sodiu())>1251){
            zsodiu2 =13;
        }
        if(Integer.parseInt(product.get_sodiu())>1397){
            zsodiu2=14;
        }
        if(Integer.parseInt(product.get_sodiu())>1559){
            zsodiu2 =15;
        }
        if(Double.parseDouble(product.get_sodiu())>1740){
            zsodiu2 =16;
        }
        if(Integer.parseInt(product.get_sodiu())>1942){
            zsodiu2=17;
        }
        if(Integer.parseInt(product.get_sodiu())>2168){
            zsodiu2 =18;
        }
        if(Integer.parseInt(product.get_sodiu())>2420){
            zsodiu2=19;
        }
        if(Integer.parseInt(product.get_sodiu())>2701){
            zsodiu2 =20;
        }
        if(Double.parseDouble(product.get_sodiu())>3015){
            zsodiu2 =21;
        }


        System.out.println("zsodui" +zsodiu2);
        zpoint2 = zcal2 +zsodiu2+zsfat2+zsugr2;
        System.out.println("zpoint2 -w/p&f" +zpoint2);

        if(Double.parseDouble(product.get_prote())<=1.6){
            zpro2=1;
        }
        if(Double.parseDouble(product.get_prote())>1.6){
            zpro2 =2;
        }
        if(Double.parseDouble(product.get_prote())>=3.2){
            zpro2 =3;
        }
        if(Double.parseDouble(product.get_prote())>4.8){
            zpro2=4;
        }
        if(Double.parseDouble(product.get_prote())>=8.0){
            zpro2 =5;
        }
        if(Double.parseDouble(product.get_prote())>=9.6){
            zpro2=6;
        }
        if(Double.parseDouble(product.get_prote())>=11.6){
            zpro2 =7;
        }
        if(Double.parseDouble(product.get_prote())>=13.9){
            zpro2=8;
        }
        if(Double.parseDouble(product.get_prote())>=16.7){
            zpro2=9;
        }
        if(Double.parseDouble(product.get_prote())>=20){
            zpro2 =10;
        }
        if(Double.parseDouble(product.get_prote())>=24){
            zpro2=11;
        }
        if(Double.parseDouble(product.get_prote())>=28.9){
            zpro2 =12;
        }
        if(Double.parseDouble(product.get_prote())>=34.7){
            zpro2 =13;
        }
        if(Double.parseDouble(product.get_prote())>=41.6){
            zpro2=14;
        }
        if(Double.parseDouble(product.get_prote())>=50.0){
            zpro2 =15;
        }


        System.out.println("protein: "+zpro2);

        if(Double.parseDouble(product.get_diefi())<=0.9){
            zdiefi2=0;
        }
        if(Double.parseDouble(product.get_diefi())>0.9){
            zdiefi2 =1;
        }
        if(Double.parseDouble(product.get_diefi())>1.9){
            zdiefi2 =2;
        }
        if(Double.parseDouble(product.get_diefi())>2.8){
            zdiefi2=3;
        }
        if(Double.parseDouble(product.get_diefi())>3.7){
            zdiefi2 =4;
        }
        if(Double.parseDouble(product.get_diefi())>4.7){
            zdiefi2=5;
        }
        if(Double.parseDouble(product.get_diefi())>5.4){
            zdiefi2 =6;
        }
        if(Double.parseDouble(product.get_diefi())>6.3){
            zdiefi2=7;
        }
        if(Double.parseDouble(product.get_diefi())>7.3){
            zdiefi2=8;
        }
        if(Double.parseDouble(product.get_diefi())>8.4){
            zdiefi2 =9;
        }
        if(Double.parseDouble(product.get_diefi())>9.7){
            zdiefi2=10;
        }
        if(Double.parseDouble(product.get_diefi())>11.2){
            zdiefi2 =11;
        }
        if(Double.parseDouble(product.get_diefi())>13){
            zdiefi2 =12;
        }
        if(Double.parseDouble(product.get_diefi())>15){
            zdiefi2=14;
        }
        if(Double.parseDouble(product.get_diefi())>17.3){
            zdiefi2 =14;
        }
        if(Double.parseDouble(product.get_diefi())>20){
            zdiefi2 =15;
        }


        System.out.println("zdiefi2: "+ zdiefi2);
        if(zpoint2<=13){zpoint2= (zpoint2)-(zpro2);}
        System.out.println("zpoint2 w/p" +zpoint2);
        zpoint2 -= zdiefi2;
        System.out.println("zpoint2 w/p+f" +zpoint2);
        if(zpoint2>=25){
            zhsr2 = 0.5;
        }
        if(zpoint2 >=21 & zpoint2<=24){
            zhsr2=1;
        }
        if(zpoint2 >=16 & zpoint2<=20){
            zhsr2=1.5;
        }
        if(zpoint2 >=12 & zpoint2<=15){
            zhsr2=2;
        }
        if(zpoint2 >=7 & zpoint2<=11){
            zhsr2=2.5;
        }
        if(zpoint2 >=3 & zpoint2<=6){
            zhsr2=3;
        }
        if(zpoint2 >=-1 & zpoint2<=2){
            zhsr2=3.5;
        }
        if(zpoint2 >=-6 & zpoint2<=-2){
            zhsr2=4;
        }
        if(zpoint2 >=-10 & zpoint2<=-7){
            zhsr2=4.5;
        }
        if(zpoint2 <=-11){
            zhsr2=5;
        }

    }


}
