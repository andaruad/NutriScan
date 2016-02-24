package com.fyp.andaruad.nutriscan;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/*
 * Created by Andaruad on 14/02/2016.
 */
public class SearchActivity extends ListActivity {

    static final String[] MOBILE_OS =
            new String[] { "Product1", "Product2", "Product3", "Product4"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new SearchArrayAdapter(this, MOBILE_OS));
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //get selected items
        String selectedValue = (String) getListAdapter().getItem(position);
        if(selectedValue == "Product1"){
            //Toast.makeText(getApplicationContext(),"Traaaai",Toast.LENGTH_SHORT).show();
//            TextView textView = (TextView) findViewById(R.id.textView26);
//            ProductsDB product1 = new ProductsDB("Product Name trial 1",10);
//            textView.setText(product1.getp_name());
            Intent intent = new Intent(v.getContext(),ResultActivity.class);
            startActivity(intent);


        }
        //Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
    }

}