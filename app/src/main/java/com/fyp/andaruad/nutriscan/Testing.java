package com.fyp.andaruad.nutriscan;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Testing extends Activity {
    Button add_btn;
    ListView show_product;
    ListView Product_listview;
    ArrayList<Product> contact_data = new ArrayList<Product>();
    Product_Adapter cAdapter;
    DBHandler db;
    String Toast_msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing);
        try {
            Product_listview = (ListView) findViewById(R.id.list);
            Product_listview.setItemsCanFocus(false);
            add_btn = (Button) findViewById(R.id.add_btn);

            Set_Referash_Data();

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("some error", "" + e);
        }
        add_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent add_user = new Intent(Testing.this,
                        Add_Update.class);
                add_user.putExtra("called", "add");
                add_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(add_user);
                finish();
            }
        });

//        Product_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startActivity(new Intent(getApplicationContext(), ResultActivity.class));
//                //Toast.makeText(Testing.this, "Test", Toast.LENGTH_LONG).show();
//            }
//        });
    }


    public void Set_Referash_Data() {
        contact_data.clear();
        db = new DBHandler(this);
        ArrayList<Product> contact_array_from_db = db.Get_Products();

        for (int i = 0; i < contact_array_from_db.size(); i++) {

            int tidno = contact_array_from_db.get(i).getID();
            String name = contact_array_from_db.get(i).getName();
            String barcodeNumber = contact_array_from_db.get(i).getBarcodeNumber();
            String cate = contact_array_from_db.get(i).getCate();
            String cal = contact_array_from_db.get(i).getCal();
            String tofat = contact_array_from_db.get(i).get_tofat();
            String sfat = contact_array_from_db.get(i).get_sfat();
            String trfat = contact_array_from_db.get(i).get_trfat();

            String chole = contact_array_from_db.get(i).get_chole();
            String sodiu = contact_array_from_db.get(i).get_sodiu();
            String carbs = contact_array_from_db.get(i).get_carbs();
            String dietfi = contact_array_from_db.get(i).get_diefi();
            String sugr = contact_array_from_db.get(i).get_sugr();
            String prote = contact_array_from_db.get(i).get_prote();
            String vitd = contact_array_from_db.get(i).get_vitd();
            String calc = contact_array_from_db.get(i).get_calc();
            String iron = contact_array_from_db.get(i).get_iron();
            String potas = contact_array_from_db.get(i).get_potas();
            String sersi = contact_array_from_db.get(i).get_sersi();

            Product pdct = new Product();
            pdct.setID(tidno);
            pdct.setName(name);
            pdct.setCate(cate);
            pdct.setBarcodeNumber(barcodeNumber);
            pdct.setCal(cal);
            pdct.set_tofat(tofat);pdct.set_sfat(sfat);pdct.set_trfat(trfat);

            pdct.set_chole(chole);pdct.set_sodiu(sodiu);pdct.set_carbs(carbs);pdct.set_diefi(dietfi);
            pdct.set_sugr(sugr);pdct.set_prote(prote);pdct.set_vitd(vitd);
            pdct.set_calc(calc);pdct.set_iron(iron);pdct.set_potas(potas);
            pdct.set_sersi(sersi);

            contact_data.add(pdct);
        }
        db.close();
        cAdapter = new Product_Adapter(Testing.this, R.layout.list_view_row,
                contact_data);
        Product_listview.setAdapter(cAdapter);
        cAdapter.notifyDataSetChanged();
    }

    public void Show_Toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Set_Referash_Data();

    }

    public class Product_Adapter extends ArrayAdapter<Product> {
        Activity activity;
        int layoutResourceId;
        Product user;
        ArrayList<Product> data = new ArrayList<Product>();

        public Product_Adapter(Activity act, int layoutResourceId,
                               ArrayList<Product> data) {
            super(act, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.activity = act;
            this.data = data;
            notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            UserHolder holder = null;

            if (row == null) {
                LayoutInflater inflater = LayoutInflater.from(activity);

                row = inflater.inflate(layoutResourceId, parent, false);
                holder = new UserHolder();
                holder.name = (TextView) row.findViewById(R.id.user_name_txt);
                holder.cate = (TextView) row.findViewById(R.id.user_email_txt);
                holder.number = (TextView) row.findViewById(R.id.user_mob_txt);
                holder.cal = (TextView) row.findViewById(R.id.user_cal_txt);                           // do something
//


                holder.edit = (Button) row.findViewById(R.id.btn_update);
                holder.delete = (Button) row.findViewById(R.id.btn_delete);
                holder.showproduct = (ListView) row.findViewById(R.id.list);
                row.setTag(holder);
            } else {
                holder = (UserHolder) row.getTag();
            }
            user = data.get(position);
            holder.edit.setTag(user.getID());
            holder.delete.setTag(user.getID());
            holder.name.setText(user.getName());
            holder.cate.setText(user.getCate());
            holder.number.setText(user.getBarcodeNumber());
            holder.edit.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.i("Edit Button Clicked", "**********");

                    Intent update_user = new Intent(activity,
                            Add_Update.class);
                    update_user.putExtra("called", "update");
                    update_user.putExtra("USER_ID", v.getTag().toString());
                    activity.startActivity(update_user);

                }
            });
            holder.delete.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(final View v) {
                    // TODO Auto-generated method stub

                    // show a message while loader is loading

                    AlertDialog.Builder adb = new AlertDialog.Builder(activity);
                    adb.setTitle("Delete?");
                    adb.setMessage("Are you sure you want to delete ");
                    final int user_id = Integer.parseInt(v.getTag().toString());
                    adb.setNegativeButton("Cancel", null);
                    adb.setPositiveButton("Ok",
                            new AlertDialog.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // MyDataObject.remove(positionToRemove);
                                    DBHandler dBHandler = new DBHandler(
                                            activity.getApplicationContext());
                                    dBHandler.Delete_Product(user_id);
                                    Testing.this.onResume();

                                }
                            });
                    adb.show();
                }

            });
            return row;


        }

        class UserHolder {
            TextView name;
            TextView cate;
            TextView number;
            TextView cal;
            Button edit;
            Button delete;
            ListView showproduct;
        }

    }

}
