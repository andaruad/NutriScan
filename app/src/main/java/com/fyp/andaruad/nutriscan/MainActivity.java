package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.net.URI;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Get Object from StoreValue
        //final StoreValue value1 = new StoreValue();

        //Barcode Button
        ImageButton bbarcode = (ImageButton)findViewById(R.id.bbarcode);
        bbarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                integrator.initiateScan();}
        });
        bbarcode.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View arg0) {
                Toast toast= Toast.makeText(getApplicationContext(),
                        "Press Button to Scan Barcode", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 140);
                toast.show();
                return true;
            }

        });

        //Search Button
        ImageButton bsearch = (ImageButton)findViewById(R.id.bsearch);
        bsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SearchActivity.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"bsearch button",Toast.LENGTH_LONG).show();
            }});
        bsearch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View arg0) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Press Button to View Products", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 140);
                toast.show();
                return true;
            }

        });

        //History Button
        ImageButton bhistory=(ImageButton)findViewById(R.id.bhistory);
        bhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SearchActivity.class);
                startActivity(intent);
//       Toast.makeText(getApplicationContext(),"bhistory button",Toast.LENGTH_SHORT).show();
            }
        });
        //Text View
            //TextView tvresult = (TextView) findViewById(R.id.tvresult);
            //tvresult.setText("Apa kek");
            }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode,resultCode, intent);
            if (scanResult != null){
                String re = scanResult.getContents();
                Log.d("code", re);
                TextView tvresult = (TextView) findViewById(R.id.tvresult);
                tvresult.setText("Your scanned barcode is:\n" + re);
                Intent compare = new Intent(this, CompareMain.class);
                compare.putExtra("barcode_num1", re);
                startActivity(compare);
            }else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "No scan data received!", Toast.LENGTH_LONG);
                toast.show();
            }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private LayoutInflater pop;
    private PopupWindow popupWindow;
    private RelativeLayout relativeLayout;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //startActivity(new Intent(MainActivity.this,Help.class));
            pop = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            relativeLayout = (RelativeLayout) findViewById(R.id.main);
            ViewGroup container = (ViewGroup) pop.inflate(R.layout.help,null);
            popupWindow = new PopupWindow(container, RelativeLayout.LayoutParams
                    .WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT,true);
            popupWindow.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);
            ImageButton close = (ImageButton)findViewById(R.id.ic_exit);
//
//            close.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    popupWindow.dismiss();
//
//                }
//            });
            }
       return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.diettypes) {
            startActivity(new Intent(getApplicationContext(),DietTypes.class));
        } else if (id == R.id.addproduct) {
            startActivity(new Intent(getApplicationContext(),AddProduct.class));
        } else if (id == R.id.about) {
            startActivity(new Intent(getApplicationContext(),About.class));
        }
        else if (id == R.id.nav_share) {
            Uri uri = Uri.parse("https://www.facebook.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }else if (id == R.id.testing) {
            startActivity(new Intent(getApplicationContext(),Testing.class));}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
