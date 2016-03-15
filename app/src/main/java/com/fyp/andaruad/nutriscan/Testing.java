package com.fyp.andaruad.nutriscan;

    import java.util.ArrayList;
    import java.util.List;

    import android.app.Activity;
    import android.app.AlertDialog;
    import android.app.ListActivity;
    import android.content.DialogInterface;
    import android.content.Intent;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.AdapterView;
    import android.widget.AdapterView.OnItemClickListener;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.ListView;
    import android.widget.TextView;
    import android.widget.Toast;

public class Testing extends Activity {
    Button add_btn;
    ListView Contact_listview;
    ArrayList<Product> contact_data = new ArrayList<Product>();
    Product_Adapter cAdapter;
    DBHandler db;
    String Toast_msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing);
        try{
            Contact_listview = (ListView) findViewById(R.id.list);
            Contact_listview.setItemsCanFocus(false);
            add_btn = (Button) findViewById(R.id.add_btn);

            Set_Refresh_Data();

        }catch (Exception e){
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
    }
    public void Set_Refresh_Data() {
        contact_data.clear();
        db = new DBHandler(this);
        ArrayList<Product> contact_array_from_db = db.Get_Product();

        for (int i = 0; i < contact_array_from_db.size(); i++) {

            int tidno = contact_array_from_db.get(i).getId();
            String name = contact_array_from_db.get(i).getP_name();
            String barcode = contact_array_from_db.get(i).getP_barcode();
            String category = contact_array_from_db.get(i).getP_category();
            Product cnt = new Product();
            cnt.setId(tidno);
            cnt.setP_name(name);
            cnt.setP_barcode(barcode);
            cnt.setP_category(category);

            contact_data.add(cnt);
        }
        db.close();
        cAdapter = new Product_Adapter(Testing.this, R.layout.list_view_row,
                contact_data);
        Contact_listview.setAdapter(cAdapter);
        cAdapter.notifyDataSetChanged();
    }
    public void Show_Toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Set_Refresh_Data();
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
                holder.name = (TextView) row.findViewById(R.id.product_name_txt);
                holder.category = (TextView) row.findViewById(R.id.product_category_txt); // could cause problem
                holder.number = (TextView) row.findViewById(R.id.product_barcode_txt);
                holder.edit = (Button) row.findViewById(R.id.btn_update);
                holder.delete = (Button) row.findViewById(R.id.btn_delete);
                row.setTag(holder);
            } else {
                holder = (UserHolder) row.getTag();
            }
            user = data.get(position);
            holder.edit.setTag(user.getId());
            holder.delete.setTag(user.getId());
            holder.name.setText(user.getP_name());
            holder.category.setText(user.getP_category());
            holder.number.setText(user.getP_barcode());

            holder.edit.setOnClickListener(new View.OnClickListener() {

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
            holder.delete.setOnClickListener(new View.OnClickListener() {

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
            TextView category;
            TextView number;
            Button edit;
            Button delete;
        }

    }

}