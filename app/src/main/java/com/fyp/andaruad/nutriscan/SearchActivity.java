package com.fyp.andaruad.nutriscan;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/*
 * Created by Andaruad on 14/02/2016.
 */
public class SearchActivity extends ListActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1,"Skippy Creamy","",""));
        products.add(new Product(2,"Jif Chunky","",""));
        products.add(new Product(3,"Peter Pan","",""));
        products.add(new Product(4,"P28 Peanut Butter Spread","",""));
        setListAdapter(new SearchArrayAdapter(this, products));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //get selected items
        long  selectedValue = getListAdapter().getItemId(position);
        Intent intent = new Intent(v.getContext(),ResultActivity.class);
        intent.putExtra("productid", selectedValue);
        startActivity(intent);
        //Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
    }

}