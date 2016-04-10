package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_main);

        DBHandler dbHandler = new DBHandler(this);
        result1 = getIntent().getStringExtra("barcode_num1");
        diettypes = getIntent().getStringExtra("diet");
        resultx1 = Long.parseLong(getIntent().getStringExtra("barcode_num1"));
//        diettypes = getIntent().getStringExtra("diet");
        product = dbHandler.Get_Bar(resultx1);

        if(product == null ){
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

        } else{

            Toast toast = Toast.makeText(getApplicationContext(),
                    "The product you scanned exist in the Database "+diettypes, Toast.LENGTH_LONG);
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


        TextView tv =(TextView) findViewById(R.id.tvresult2);
        tv.setText("   " + result1);

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
        calori.setText(product.getCal());
        pname = (TextView) findViewById(R.id.pname1);
        pname.setText(product.getName());
        tfat= (TextView)findViewById(R.id.tofatsmall);
        tfat.setText(product.get_tofat());
        sfat= (TextView)findViewById(R.id.sfatsmall);
        sfat.setText(product.get_sfat());
        trfat= (TextView)findViewById(R.id.trfatsmall);
        trfat.setText(product.get_trfat());
        chloe= (TextView)findViewById(R.id.chloesmall);
        chloe.setText(product.get_chole());
        sodiu= (TextView)findViewById(R.id.sodiusmall);
        sodiu.setText(product.get_sodiu());
        carbs= (TextView)findViewById(R.id.carbssmall);
        carbs.setText(product.get_carbs());
        diefi= (TextView)findViewById(R.id.diefismall);
        diefi.setText(product.get_diefi());
        sugar= (TextView)findViewById(R.id.sugrsmall);
        sugar.setText(product.get_sugr());
        protein= (TextView)findViewById(R.id.protesmall);
        protein.setText(product.get_prote());
        vitd= (TextView)findViewById(R.id.vitdsmall);
        vitd.setText(product.get_vitd());
        calc= (TextView)findViewById(R.id.calcsmall);
        calc.setText(product.get_calc());
        iron= (TextView)findViewById(R.id.ironsmall);
        iron.setText(product.get_iron());
        potas= (TextView)findViewById(R.id.potassmall);
        potas.setText(product.get_potas());
        sersi=(TextView)findViewById(R.id.servesmall);
        sersi.setText("  "+ product.get_sersi());

        int divider = 100/(Integer.parseInt(product.get_sersi().toString()));
        calori2 = (TextView) findViewById(R.id.caloriessmall2);
        calori2.setText((Integer.parseInt(product.getCal().toString()))/divider+"");
        tfat2= (TextView)findViewById(R.id.tofatsmall2);
        tfat2.setText((Integer.parseInt(product.get_tofat().toString()))/divider+"");
        sfat2= (TextView)findViewById(R.id.sfatsmall2);
        sfat2.setText((Integer.parseInt(product.get_sfat().toString()))/divider+"");
        trfat2= (TextView)findViewById(R.id.trfatsmall2);
        trfat2.setText((Integer.parseInt(product.get_trfat().toString()))/divider+"");
        chloe2= (TextView)findViewById(R.id.chloesmall2);
        chloe2.setText((Integer.parseInt(product.get_chole().toString()))/divider+"");
        sodiu2= (TextView)findViewById(R.id.sodiusmall2);
        sodiu2.setText((Integer.parseInt(product.get_sodiu().toString()))/divider+"");
        carbs2= (TextView)findViewById(R.id.carbssmall2);
        carbs2.setText((Integer.parseInt(product.get_carbs().toString()))/divider+"");
        diefi2= (TextView)findViewById(R.id.diefismall2);
        diefi2.setText((Integer.parseInt(product.get_diefi().toString()))/divider+"");
        sugar2= (TextView)findViewById(R.id.sugrsmall2);
        sugar2.setText(((Integer.parseInt(product.get_sugr().toString()))/divider+""));
        protein2= (TextView)findViewById(R.id.protesmall2);
        protein2.setText((Integer.parseInt(product.get_prote().toString()))/divider+"");
        vitd2= (TextView)findViewById(R.id.vitdsmall2);
        vitd2.setText((Integer.parseInt(product.get_vitd().toString()))/divider+"");
        calc2= (TextView)findViewById(R.id.calcsmall2);
        calc2.setText((Integer.parseInt(product.get_calc().toString()))/divider+"");
        iron2= (TextView)findViewById(R.id.ironsmall2);
        iron2.setText((Integer.parseInt(product.get_iron().toString()))/divider+"");
        potas2= (TextView)findViewById(R.id.potassmall2);
        potas2.setText((Integer.parseInt(product.get_potas().toString()))/divider+"");
    }




}
