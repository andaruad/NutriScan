package com.fyp.andaruad.nutriscan;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/*
 * Created by Andaruad on 14/02/2016.
 */
public class SearchActivity extends ListActivity {

    static final String[] MOBILE_OS =
            new String[] { "Android", "iOS", "WindowsMobile", "Blackberry"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new SearchArrayAdapter(this, MOBILE_OS));

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //get selected items
        String selectedValue = (String) getListAdapter().getItem(position);
        if(selectedValue == "Android"){
            Toast.makeText(getApplicationContext(),"Traaaai",Toast.LENGTH_SHORT).show();

        };



        //Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();

    }

}