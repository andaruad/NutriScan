package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Andaruad on 22/02/2016.
 */
public class DietTypes extends Activity{
private RadioButton dietbutton;
    private RadioGroup dietgroup;


    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_types);



    }

    public void addListenerButton(){
        dietgroup = (RadioGroup)findViewById(R.id.dietgroup);

        Button done = (Button)findViewById(R.id.Done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int selectedId = dietgroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                //dietbutton = (RadioButton) findViewById(selectedId);

//                Toast.makeText(DietTypes.this,
//                        dietbutton.getText(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
