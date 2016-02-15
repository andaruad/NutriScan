package com.fyp.andaruad.nutriscan;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * Created by Andaruad on 14/02/2016.
 */
public class SearchArrayAdapter extends ArrayAdapter<String>{
        private final Context context;
        private final String[] values;

        public SearchArrayAdapter(Context context, String[] values) {
            super(context, R.layout.search_main, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.search_main, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.listlabel);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            textView.setText(values[position]);

            // Change icon based on name
            String s = values[position];

            System.out.println(s);

            if (s.equals("WindowsMobile")) {
                imageView.setImageResource(R.mipmap.ic_launcher);
            } else if (s.equals("iOS")) {
                imageView.setImageResource(R.mipmap.ic_launcher);
            } else if (s.equals("Blackberry")) {
                imageView.setImageResource(R.mipmap.ic_launcher);
            } else {
                imageView.setImageResource(R.mipmap.ic_launcher);
            }

            return rowView;
        }








}
