package com.fyp.andaruad.nutriscan;

 import java.util.ArrayList;
        import java.util.List;

        import android.app.ListActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.ArrayAdapter;

public class Testing extends ListActivity implements OnItemClickListener {
    DBHandler db = new DBHandler(this);
    List list;
    ArrayAdapter myAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
        // start BookActivity with extras the book id
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}