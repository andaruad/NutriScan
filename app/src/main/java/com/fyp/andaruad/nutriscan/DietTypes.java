package com.fyp.andaruad.nutriscan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

// * Created by Andaruad on 22/02/2016.

public class DietTypes extends Activity {
    private RadioButton dietbutton;
    private RadioGroup dietgroup;
    private RadioButton vege, halal, soy, shell, peanut, vegan, high;
    private Button done;
    private String choice;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_types);
        dietgroup = (RadioGroup) findViewById(R.id.dietgroup);


//        dietgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                // find which radio button is selected
//                if (checkedId == R.id.vegan) {
////                    Toast.makeText(getApplicationContext(), "choice: vegan",
////                            Toast.LENGTH_SHORT).show();
//                } else if (checkedId == R.id.halal) {
//                } else if (checkedId == R.id.halal){
//                }
//            }
//        });

        vegan = (RadioButton) findViewById(R.id.vegan);
        halal = (RadioButton) findViewById(R.id.halal);
        peanut = (RadioButton) findViewById(R.id.peanut);
        soy = (RadioButton) findViewById(R.id.soy);
        shell = (RadioButton) findViewById(R.id.shell);
        high = (RadioButton) findViewById(R.id.high);

        done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = dietgroup.getCheckedRadioButtonId();

                // find which radioButton is checked by id
                if (selectedId == halal.getId()) {
                    choice = "Halal";
                }
                if (selectedId == vegan.getId()) {
                    choice = "vegan";
                }
                if (selectedId == peanut.getId()) {
                    choice = "Peanut Butter";
                }
                if (selectedId == soy.getId()) {
                    choice = "Soy Allergy";
                }
                if (selectedId == shell.getId()) {
                    choice = "sge";
                }
                if (selectedId == high.getId()) {
                    choice = "highCo";
                }
                if (selectedId == halal.getId()) {
                    choice = "Halal";
                }
                Intent diet = new Intent(v.getContext(),CompareMain.class);
                diet.putExtra("diet", choice);

                Intent intent = new Intent(v.getContext(),MainActivity.class);
                intent.putExtra("diet", choice);
                Toast.makeText(getApplicationContext(), "Your Diet type is " + choice,
                            Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }

}
