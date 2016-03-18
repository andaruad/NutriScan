package com.fyp.andaruad.nutriscan;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

/*
 * Created by Andaruad on 14/02/2016.
 */
public class SearchArrayAdapter extends ArrayAdapter<Product>{

        private Context context;
        private ArrayList<Product> products;

        public SearchArrayAdapter(Context context, ArrayList<Product> products) {
            super(context, R.layout.search_main);
            this.context = context;
            this.products = products;
        }

        @Override
        public Product getItem(int position){
            return products.get(position);
        }

        @Override
        public long getItemId(int position){
           return getItem(position).getID();
        }

        @Override
        public int getCount(){
            return products.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            Product currentProduct = getItem(position);
            View rowView = inflater.inflate(R.layout.search_main, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.listlabel);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            textView.setText(currentProduct.getName());


            return rowView;
        }









}
