package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//Created by Andaruad on 27/03/2016.

public class CompareFinal extends Activity{
TextView barcodeF1, barcodeF2;
String result1, result2;
long resultx1,resultx2;
Product product1, product2;
DBHandler dbHandler;
Toast toastz;
TextView calori2, pname2,  tfat2, sfat2,trfat2, chloe2, sodiu2, carbs2, diefi2, sugar2, protein2, vitd2, calc2, iron2, potas2;
TextView calori1, pname1,  tfat1, sfat1,trfat1, chloe1, sodiu1, carbs1, diefi1, sugar1, protein1, vitd1, calc1, iron1, potas1;
TextView calori3, pname3,  tfat3, sfat3,trfat3, chloe3, sodiu3, carbs3, diefi3, sugar3, protein3, vitd3, calc3, iron3, potas3;
TextView calori4, pname4,  tfat4, sfat4,trfat4, chloe4, sodiu4, carbs4, diefi4, sugar4, protein4, vitd4, calc4, iron4, potas4;
double zpoint,zhsr, zcal, zsfat, zsugr, zsodiu,zpro, zdiefi;
double zpoint2,zhsr2, zcal2, zsfat2, zsugr2, zsodiu2,zpro2, zdiefi2;
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
                            Intent intent = new Intent(getApplicationContext(), Addlist.class);
                            startActivity(intent);
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();

        }else{


            TVholder();

//            Addition1();

            Calculation1();
            Calculation2();
            Rating();


            Toast toast = Toast.makeText(getApplicationContext(),
                    "The product you scanned exist in Database", Toast.LENGTH_SHORT);
            toast.show();
          System.out.println(zhsr);
            System.out.println(zhsr2);
            ImageView recommend = (ImageView)findViewById(R.id.recommend1);
            if (zhsr==0.5){
                recommend.setImageResource(R.drawable.half);
            }
            if (zhsr==1){
                recommend.setImageResource(R.drawable.one);
            }
            if (zhsr==1.5){
                recommend.setImageResource(R.drawable.onehalf);
            }
            if (zhsr==2){
                recommend.setImageResource(R.drawable.two);
            }
            if (zhsr==2.5){
                recommend.setImageResource(R.drawable.twohalf);
            }
            if (zhsr==3){
                recommend.setImageResource(R.drawable.three);
            }
            if (zhsr==3.5){
                recommend.setImageResource(R.drawable.threehalf);
            }
            if (zhsr==4){
                recommend.setImageResource(R.drawable.four);
            }
            if (zhsr==4.5){
                recommend.setImageResource(R.drawable.fourhalf);
            }
            if (zhsr==5){
                recommend.setImageResource(R.drawable.five);
            }

            ImageView recommend2 = (ImageView)findViewById(R.id.recommend2);
            if (zhsr2==0.5){
                recommend2.setImageResource(R.drawable.half);
            }
            if (zhsr2==1){
                recommend2.setImageResource(R.drawable.one);
            }
            if (zhsr2==1.5){
                recommend2.setImageResource(R.drawable.onehalf);
            }
            if (zhsr2==2){
                recommend2.setImageResource(R.drawable.two);
            }
            if (zhsr2==2.5){
                recommend2.setImageResource(R.drawable.twohalf);
            }
            if (zhsr2==3){
                recommend2.setImageResource(R.drawable.three);
            }
            if (zhsr2==3.5){
                recommend2.setImageResource(R.drawable.threehalf);
            }
            if (zhsr2==4){
                recommend2.setImageResource(R.drawable.four);
            }
            if (zhsr2==4.5){
                recommend2.setImageResource(R.drawable.fourhalf);
            }
            if (zhsr2==5){
                recommend2.setImageResource(R.drawable.five);
            }

            TextView recommend3 = (TextView)findViewById(R.id.frecommend);
            if(zhsr>zhsr2) {
                recommend3.setText("Better product is " + product1.getName());
            }
            else if(zhsr2>zhsr)
            {
                recommend3.setText("Better product is " + product2.getName());
            }
            else {recommend3.setText("Products have equal rating");}



    }
        //Display

    }

    public void Calculation1(){

        //Calories in KJ
        if(Integer.parseInt(product1.getCal())<=335){
            zcal=0;
        }
        if(Integer.parseInt(product1.getCal())>335){
            zcal=1;
        }
        if(Integer.parseInt(product1.getCal())>670){
            zcal=2;
        }
        if(Integer.parseInt(product1.getCal())>1005){
            zcal=3;
        }
        if(Integer.parseInt(product1.getCal())>1340){
            zcal=4;
        }
        if(Integer.parseInt(product1.getCal())>1675){
            zcal=5;
        }
        if(Integer.parseInt(product1.getCal())>2010){
            zcal=6;
        }
        if(Integer.parseInt(product1.getCal())>2345){
            zcal=7;
        }
        if(Integer.parseInt(product1.getCal())>2680){
            zcal=8;
        }
        if(Integer.parseInt(product1.getCal())>3015){
            zcal=9;
        }
        if(Integer.parseInt(product1.getCal())>3350){
            zcal=10;
        }
        if(Integer.parseInt(product1.getCal())>3686){
            zcal=11;
        }


        System.out.println("zcal: "+zcal);

        //Saturated Fat
        if(Integer.parseInt(product1.get_sfat())<1){
            zsfat=0;
        }
        if(Integer.parseInt(product1.get_sfat())>=1){
            zsfat=1;
        }
        if(Integer.parseInt(product1.get_sfat())>=2){
            zsfat=2;
        }
        if(Integer.parseInt(product1.get_sfat())>=3){
            zsfat=3;
        }
        if(Integer.parseInt(product1.get_sfat())>=4){
            zsfat=4;
        }
        if(Integer.parseInt(product1.get_sfat())>=5){
            zsfat=5;
        }
        if(Double.parseDouble(product1.get_sfat())>=6){
            zsfat=6;
        }
        if(Double.parseDouble(product1.get_sfat())>=7){
            zsfat=7;
        }
        if(Double.parseDouble(product1.get_sfat())>=8){
            zsfat=8;
        }
        if(Double.parseDouble(product1.get_sfat())>=9){
            zsfat=9;
        }
        if(Double.parseDouble(product1.get_sfat())>=10.0){
            zsfat=10;
        }
        if(Double.parseDouble(product1.get_sfat())>=11.2){
            zsfat=11;
        }
        if(Double.parseDouble(product1.get_sfat())>=12.5){
            zsfat=12;
        }
        if(Double.parseDouble(product1.get_sfat())>=13.9){
            zsfat=13;
        }
        if(Integer.parseInt(product1.get_sfat())>=15.5){
            zsfat=14;
        }
        if(Double.parseDouble(product1.get_sfat())>=17.3){
            zsfat=15;
        }
        if(Double.parseDouble(product1.get_sfat())>=19.3){
            zsfat=16;
        }
        if(Double.parseDouble(product1.get_sfat())>=21.6){
            zsfat=17;
        }
        if(Double.parseDouble(product1.get_sfat())>=24.1){
            zsfat=18;
        }

        System.out.println("zsfat: "+ zsfat);


        if(Double.parseDouble(product1.get_sugr())<=5){
            zsugr =0;
        }
        if(Double.parseDouble(product1.get_sugr())>5){
            zsugr=1;
        }
        if(Integer.parseInt(product1.get_sugr())>9){
            zsugr =2;
        }
        if(Double.parseDouble(product1.get_sugr())>13.5){
            zsugr=3;
        }
        if(Double.parseDouble(product1.get_sugr())>18){
            zsugr =4;
        }
        if(Double.parseDouble(product1.get_sugr())>22.5){
            zsugr =5;
        }
        if(Double.parseDouble(product1.get_sugr())>27){
            zsugr=6;
        }
        if(Integer.parseInt(product1.get_sugr())>31){
            zsugr =7;
        }
        if(Integer.parseInt(product1.get_sugr())>36){
            zsugr=8;
        }
        if(Integer.parseInt(product1.get_sugr())>40){
            zsugr =9;
        }
        if(Double.parseDouble(product1.get_sugr())>45){
            zsugr =10;
        }
        if(Double.parseDouble(product1.get_sugr())>49){
            zsugr=11;
        }
        if(Integer.parseInt(product1.get_sugr())>54){
            zsugr =12;
        }
        if(Integer.parseInt(product1.get_sugr())>58){
            zsugr=13;
        }
        if(Integer.parseInt(product1.get_sugr())>63){
            zsugr =14;
        }
        if(Double.parseDouble(product1.get_sugr())>67){
            zsugr =15;
        }
        if(Double.parseDouble(product1.get_sugr())>72){
            zsugr=16;
        }
        if(Integer.parseInt(product1.get_sugr())>76){
            zsugr =17;
        }
        if(Integer.parseInt(product1.get_sugr())>81){
            zsugr=18;
        }
        if(Integer.parseInt(product1.get_sugr())>85){
            zsugr =19;
        }
        if(Double.parseDouble(product1.get_sugr())>90){
            zsugr =20;
        }
        if(Double.parseDouble(product1.get_sugr())>94){
            zsugr=21;
        }
        if(Integer.parseInt(product1.get_sugr())>99){
            zsugr =22;
        }





        System.out.println("zsugr: "+zsugr);


        if(Double.parseDouble(product1.get_sodiu())<=90){
            zsodiu =0;
        }
        if(Integer.parseInt(product1.get_sodiu())>90){
            zsodiu=1;
        }
        if(Integer.parseInt(product1.get_sodiu())>180){
            zsodiu =2;
        }
        if(Integer.parseInt(product1.get_sodiu())>270){
            zsodiu=3;
        }
        if(Integer.parseInt(product1.get_sodiu())>360){
            zsodiu =4;
        }
        if(Double.parseDouble(product1.get_sodiu())>450){
            zsodiu =5;
        }
        if(Double.parseDouble(product1.get_sodiu())>540){
            zsodiu =6;
        }
        if(Integer.parseInt(product1.get_sodiu())>630){
            zsodiu=7;
        }
        if(Integer.parseInt(product1.get_sodiu())>720){
            zsodiu =8;
        }
        if(Integer.parseInt(product1.get_sodiu())>810){
            zsodiu=9;
        }
        if(Integer.parseInt(product1.get_sodiu())>900){
            zsodiu =10;
        }
        if(Double.parseDouble(product1.get_sodiu())>1005){
            zsodiu =11;
        }
        if(Integer.parseInt(product1.get_sodiu())>1121){
            zsodiu=12;
        }
        if(Integer.parseInt(product1.get_sodiu())>1251){
            zsodiu =13;
        }
        if(Integer.parseInt(product1.get_sodiu())>1397){
            zsodiu=14;
        }
        if(Integer.parseInt(product1.get_sodiu())>1559){
            zsodiu =15;
        }
        if(Double.parseDouble(product1.get_sodiu())>1740){
            zsodiu =16;
        }
        if(Integer.parseInt(product1.get_sodiu())>1942){
            zsodiu=17;
        }
        if(Integer.parseInt(product1.get_sodiu())>2168){
            zsodiu =18;
        }
        if(Integer.parseInt(product1.get_sodiu())>2420){
            zsodiu=19;
        }
        if(Integer.parseInt(product1.get_sodiu())>2701){
            zsodiu =20;
        }
        if(Double.parseDouble(product1.get_sodiu())>3015){
            zsodiu =21;
        }


        System.out.println("zsodui" +zsodiu);
        zpoint = zcal +zsodiu+zsfat+zsugr;
        System.out.println("zpoint -w/p&f" +zpoint);

        if(Double.parseDouble(product1.get_prote())<=1.6){
            zpro=1;
        }
        if(Double.parseDouble(product1.get_prote())>1.6){
            zpro =2;
        }
        if(Double.parseDouble(product1.get_prote())>=3.2){
            zpro =3;
        }
        if(Double.parseDouble(product1.get_prote())>4.8){
            zpro=4;
        }
        if(Double.parseDouble(product1.get_prote())>=8.0){
            zpro =5;
        }
        if(Double.parseDouble(product1.get_prote())>=9.6){
            zpro=6;
        }
        if(Double.parseDouble(product1.get_prote())>=11.6){
            zpro =7;
        }
        if(Double.parseDouble(product1.get_prote())>=13.9){
            zpro=8;
        }
        if(Double.parseDouble(product1.get_prote())>=16.7){
            zpro=9;
        }
        if(Double.parseDouble(product1.get_prote())>=20){
            zpro =10;
        }
        if(Double.parseDouble(product1.get_prote())>=24){
            zpro=11;
        }
        if(Double.parseDouble(product1.get_prote())>=28.9){
            zpro =12;
        }
        if(Double.parseDouble(product1.get_prote())>=34.7){
            zpro =13;
        }
        if(Double.parseDouble(product1.get_prote())>=41.6){
            zpro=14;
        }
        if(Double.parseDouble(product1.get_prote())>=50.0){
            zpro =15;
        }


        System.out.println("protein: "+zpro);

        if(Double.parseDouble(product1.get_diefi())<=0.9){
            zdiefi=0;
        }
        if(Double.parseDouble(product1.get_diefi())>0.9){
            zdiefi =1;
        }
        if(Double.parseDouble(product1.get_diefi())>1.9){
            zdiefi =2;
        }
        if(Double.parseDouble(product1.get_diefi())>2.8){
            zdiefi=3;
        }
        if(Double.parseDouble(product1.get_diefi())>3.7){
            zdiefi =4;
        }
        if(Double.parseDouble(product1.get_diefi())>4.7){
            zdiefi=5;
        }
        if(Double.parseDouble(product1.get_diefi())>5.4){
            zdiefi =6;
        }
        if(Double.parseDouble(product1.get_diefi())>6.3){
            zdiefi=7;
        }
        if(Double.parseDouble(product1.get_diefi())>7.3){
            zdiefi=8;
        }
        if(Double.parseDouble(product1.get_diefi())>8.4){
            zdiefi =9;
        }
        if(Double.parseDouble(product1.get_diefi())>9.7){
            zdiefi=10;
        }
        if(Double.parseDouble(product1.get_diefi())>11.2){
            zdiefi =11;
        }
        if(Double.parseDouble(product1.get_diefi())>13){
            zdiefi =12;
        }
        if(Double.parseDouble(product1.get_diefi())>15){
            zdiefi=14;
        }
        if(Double.parseDouble(product1.get_diefi())>17.3){
            zdiefi =14;
        }
        if(Double.parseDouble(product1.get_diefi())>20){
            zdiefi =15;
        }


        System.out.println("zdiefi: "+ zdiefi);
        if(zpoint<=13){zpoint= (zpoint)-(zpro);}
        System.out.println("zpoint w/p" +zpoint);
        zpoint -= zdiefi;
        System.out.println("zpoint w/p+f" +zpoint);
        if(zpoint>=25){
            zhsr = 0.5;
        }
        if(zpoint >=21 & zpoint<=24){
            zhsr=1;
        }
        if(zpoint >=16 & zpoint<=20){
            zhsr=1.5;
        }
        if(zpoint >=12 & zpoint<=15){
            zhsr=2;
        }
        if(zpoint >=7 & zpoint<=11){
            zhsr=2.5;
        }
        if(zpoint >=3 & zpoint<=6){
            zhsr=3;
        }
        if(zpoint >=-1 & zpoint<=2){
            zhsr=3.5;
        }
        if(zpoint >=-6 & zpoint<=-2){
            zhsr=4;
        }
        if(zpoint >=-10 & zpoint<=-7){
            zhsr=4.5;
        }
        if(zpoint <=-11){
            zhsr=5;
        }
    }

    public void Calculation2(){

        //Calories in KJ
            if(Integer.parseInt(product2.getCal())<=335){
                zcal2=0;
            }
            if(Integer.parseInt(product2.getCal())>335){
                zcal2=1;
            }
            if(Integer.parseInt(product2.getCal())>670){
                zcal2=2;
            }
            if(Integer.parseInt(product2.getCal())>1005){
                zcal2=3;
            }
            if(Integer.parseInt(product2.getCal())>1340){
                zcal2=4;
            }
            if(Integer.parseInt(product2.getCal())>1675){
                zcal2=5;
            }
            if(Integer.parseInt(product2.getCal())>2010){
                zcal2=6;
            }
            if(Integer.parseInt(product2.getCal())>2345){
                zcal2=7;
            }
            if(Integer.parseInt(product2.getCal())>2680){
                zcal2=8;
            }
            if(Integer.parseInt(product2.getCal())>3015){
                zcal2=9;
            }
            if(Integer.parseInt(product2.getCal())>3350){
                zcal2=10;
            }
            if(Integer.parseInt(product2.getCal())>3686){
                zcal2=11;
            }


            System.out.println("zcal2: "+zcal2);

//Saturated Fat
            if(Integer.parseInt(product2.get_sfat())<1){
                zsfat2=0;
            }
            if(Integer.parseInt(product2.get_sfat())>=1){
                zsfat2=1;
            }
            if(Integer.parseInt(product2.get_sfat())>=2){
                zsfat2=2;
            }
            if(Integer.parseInt(product2.get_sfat())>=3){
                zsfat2=3;
            }
            if(Integer.parseInt(product2.get_sfat())>=4){
                zsfat2=4;
            }
            if(Integer.parseInt(product2.get_sfat())>=5){
                zsfat2=5;
            }
            if(Double.parseDouble(product2.get_sfat())>=6){
                zsfat2=6;
            }
            if(Double.parseDouble(product2.get_sfat())>=7){
                zsfat2=7;
            }
            if(Double.parseDouble(product2.get_sfat())>=8){
                zsfat2=8;
            }
            if(Double.parseDouble(product2.get_sfat())>=9){
                zsfat2=9;
            }
            if(Double.parseDouble(product2.get_sfat())>=10.0){
                zsfat2=10;
            }
            if(Double.parseDouble(product2.get_sfat())>=11.2){
                zsfat2=11;
            }
            if(Double.parseDouble(product2.get_sfat())>=12.5){
                zsfat2=12;
            }
            if(Double.parseDouble(product2.get_sfat())>=13.9){
                zsfat2=13;
            }
            if(Integer.parseInt(product2.get_sfat())>=15.5){
                zsfat2=14;
            }
            if(Double.parseDouble(product2.get_sfat())>=17.3){
                zsfat2=15;
            }
            if(Double.parseDouble(product2.get_sfat())>=19.3){
                zsfat2=16;
            }
            if(Double.parseDouble(product2.get_sfat())>=21.6){
                zsfat2=17;
            }
            if(Double.parseDouble(product2.get_sfat())>=24.1){
                zsfat2=18;
            }

            System.out.println("zsfat2: "+ zsfat2);


            if(Double.parseDouble(product2.get_sugr())<=5){
                zsugr2 =0;
            }
            if(Double.parseDouble(product2.get_sugr())>5){
                zsugr2=1;
            }
            if(Integer.parseInt(product2.get_sugr())>9){
                zsugr2 =2;
            }
            if(Double.parseDouble(product2.get_sugr())>13.5){
                zsugr2=3;
            }
            if(Double.parseDouble(product2.get_sugr())>18){
                zsugr2 =4;
            }
            if(Double.parseDouble(product2.get_sugr())>22.5){
                zsugr2 =5;
            }
            if(Double.parseDouble(product2.get_sugr())>27){
                zsugr2=6;
            }
            if(Integer.parseInt(product2.get_sugr())>31){
                zsugr2 =7;
            }
            if(Integer.parseInt(product2.get_sugr())>36){
                zsugr2=8;
            }
            if(Integer.parseInt(product2.get_sugr())>40){
                zsugr2 =9;
            }
            if(Double.parseDouble(product2.get_sugr())>45){
                zsugr2 =10;
            }
            if(Double.parseDouble(product2.get_sugr())>49){
                zsugr2=11;
            }
            if(Integer.parseInt(product2.get_sugr())>54){
                zsugr2 =12;
            }
            if(Integer.parseInt(product2.get_sugr())>58){
                zsugr2=13;
            }
            if(Integer.parseInt(product2.get_sugr())>63){
                zsugr2 =14;
            }
            if(Double.parseDouble(product2.get_sugr())>67){
                zsugr2 =15;
            }
            if(Double.parseDouble(product2.get_sugr())>72){
                zsugr2=16;
            }
            if(Integer.parseInt(product2.get_sugr())>76){
                zsugr2 =17;
            }
            if(Integer.parseInt(product2.get_sugr())>81){
                zsugr2=18;
            }
            if(Integer.parseInt(product2.get_sugr())>85){
                zsugr2 =19;
            }
            if(Double.parseDouble(product2.get_sugr())>90){
                zsugr2 =20;
            }
            if(Double.parseDouble(product2.get_sugr())>94){
                zsugr2=21;
            }
            if(Integer.parseInt(product2.get_sugr())>99){
                zsugr2 =22;
            }





            System.out.println("zsugr2: "+zsugr2);


            if(Double.parseDouble(product2.get_sodiu())<=90){
                zsodiu2 =0;
            }
            if(Integer.parseInt(product2.get_sodiu())>90){
                zsodiu2=1;
            }
            if(Integer.parseInt(product2.get_sodiu())>180){
                zsodiu2 =2;
            }
            if(Integer.parseInt(product2.get_sodiu())>270){
                zsodiu2=3;
            }
            if(Integer.parseInt(product2.get_sodiu())>360){
                zsodiu2 =4;
            }
            if(Double.parseDouble(product2.get_sodiu())>450){
                zsodiu2 =5;
            }
            if(Double.parseDouble(product2.get_sodiu())>540){
                zsodiu2 =6;
            }
            if(Integer.parseInt(product2.get_sodiu())>630){
                zsodiu2=7;
            }
            if(Integer.parseInt(product2.get_sodiu())>720){
                zsodiu2 =8;
            }
            if(Integer.parseInt(product2.get_sodiu())>810){
                zsodiu2=9;
            }
            if(Integer.parseInt(product2.get_sodiu())>900){
                zsodiu2 =10;
            }
            if(Double.parseDouble(product2.get_sodiu())>1005){
                zsodiu2 =11;
            }
            if(Integer.parseInt(product2.get_sodiu())>1121){
                zsodiu2=12;
            }
            if(Integer.parseInt(product2.get_sodiu())>1251){
                zsodiu2 =13;
            }
            if(Integer.parseInt(product2.get_sodiu())>1397){
                zsodiu2=14;
            }
            if(Integer.parseInt(product2.get_sodiu())>1559){
                zsodiu2 =15;
            }
            if(Double.parseDouble(product2.get_sodiu())>1740){
                zsodiu2 =16;
            }
            if(Integer.parseInt(product2.get_sodiu())>1942){
                zsodiu2=17;
            }
            if(Integer.parseInt(product2.get_sodiu())>2168){
                zsodiu2 =18;
            }
            if(Integer.parseInt(product2.get_sodiu())>2420){
                zsodiu2=19;
            }
            if(Integer.parseInt(product2.get_sodiu())>2701){
                zsodiu2 =20;
            }
            if(Double.parseDouble(product2.get_sodiu())>3015){
                zsodiu2 =21;
            }


            System.out.println("zsodui" +zsodiu2);
            zpoint2 = zcal2 +zsodiu2+zsfat2+zsugr2;
            System.out.println("zpoint2 -w/p&f" +zpoint2);

            if(Double.parseDouble(product2.get_prote())<=1.6){
                zpro2=1;
            }
            if(Double.parseDouble(product2.get_prote())>1.6){
                zpro2 =2;
            }
            if(Double.parseDouble(product2.get_prote())>=3.2){
                zpro2 =3;
            }
            if(Double.parseDouble(product2.get_prote())>4.8){
                zpro2=4;
            }
            if(Double.parseDouble(product2.get_prote())>=8.0){
                zpro2 =5;
            }
            if(Double.parseDouble(product2.get_prote())>=9.6){
                zpro2=6;
            }
            if(Double.parseDouble(product2.get_prote())>=11.6){
                zpro2 =7;
            }
            if(Double.parseDouble(product2.get_prote())>=13.9){
                zpro2=8;
            }
            if(Double.parseDouble(product2.get_prote())>=16.7){
                zpro2=9;
            }
            if(Double.parseDouble(product2.get_prote())>=20){
                zpro2 =10;
            }
            if(Double.parseDouble(product2.get_prote())>=24){
                zpro2=11;
            }
            if(Double.parseDouble(product2.get_prote())>=28.9){
                zpro2 =12;
            }
            if(Double.parseDouble(product2.get_prote())>=34.7){
                zpro2 =13;
            }
            if(Double.parseDouble(product2.get_prote())>=41.6){
                zpro2=14;
            }
            if(Double.parseDouble(product2.get_prote())>=50.0){
                zpro2 =15;
            }


            System.out.println("protein: "+zpro2);

            if(Double.parseDouble(product2.get_diefi())<=0.9){
                zdiefi2=0;
            }
            if(Double.parseDouble(product2.get_diefi())>0.9){
                zdiefi2 =1;
            }
            if(Double.parseDouble(product2.get_diefi())>1.9){
                zdiefi2 =2;
            }
            if(Double.parseDouble(product2.get_diefi())>2.8){
                zdiefi2=3;
            }
            if(Double.parseDouble(product2.get_diefi())>3.7){
                zdiefi2 =4;
            }
            if(Double.parseDouble(product2.get_diefi())>4.7){
                zdiefi2=5;
            }
            if(Double.parseDouble(product2.get_diefi())>5.4){
                zdiefi2 =6;
            }
            if(Double.parseDouble(product2.get_diefi())>6.3){
                zdiefi2=7;
            }
            if(Double.parseDouble(product2.get_diefi())>7.3){
                zdiefi2=8;
            }
            if(Double.parseDouble(product2.get_diefi())>8.4){
                zdiefi2 =9;
            }
            if(Double.parseDouble(product2.get_diefi())>9.7){
                zdiefi2=10;
            }
            if(Double.parseDouble(product2.get_diefi())>11.2){
                zdiefi2 =11;
            }
            if(Double.parseDouble(product2.get_diefi())>13){
                zdiefi2 =12;
            }
            if(Double.parseDouble(product2.get_diefi())>15){
                zdiefi2=14;
            }
            if(Double.parseDouble(product2.get_diefi())>17.3){
                zdiefi2 =14;
            }
            if(Double.parseDouble(product2.get_diefi())>20){
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

    public void TVholder(){

        pname2 = (TextView)findViewById(R.id.pname2);
        pname2.setText(product2.getName());
        calori2 = (TextView) findViewById(R.id.calA2);
        calori2.setText(product2.getCal());
//        calori2.setText("XXXXX");
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
        potas3.setText((Integer.parseInt(product1.get_potas().toString())) / divider1 + "");

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
        diefi4.setText((Integer.parseInt(product2.get_diefi().toString())) / divider2 + "");
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

        TextView serving = (TextView)findViewById(R.id.textView4);
        serving.setText(product1.get_sersi().toString());
    }

    public void Rating(){

    }




}
