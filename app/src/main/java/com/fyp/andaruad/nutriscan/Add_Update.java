package com.fyp.andaruad.nutriscan;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Add_Update extends Activity {
    EditText add_name, add_barcode, add_cate, add_cal;
    Button add_save_btn, add_view_all, update_btn, update_view_all;
    LinearLayout add_view, update_view;
    String valid_bar_number = null, valid_cate = null, valid_name = null,valid_cal = null,
            Toast_msg = null, valid_user_id = "";
    int USER_ID;
    DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_update_screen);

        // set screen
        Set_Add_Update_Screen();

        // set visibility of view as per calling activity
        String called_from = getIntent().getStringExtra("called");

        if (called_from.equalsIgnoreCase("add")) {
            add_view.setVisibility(View.VISIBLE);
            update_view.setVisibility(View.GONE);
        } else {
            update_view.setVisibility(View.VISIBLE);
            add_view.setVisibility(View.GONE);
            USER_ID = Integer.parseInt(getIntent().getStringExtra("USER_ID"));

            Product c = dbHandler.Get_Product(USER_ID);

            add_name.setText(c.getName());
            add_barcode.setText(c.getBarcodeNumber());
            add_cate.setText(c.getCate());
            add_cal.setText(c.getCal());
            // dbHandler.close();
        }
        add_barcode.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                // min lenth 10 and max lenth 12 (2 extra for - as per phone
                // matcher format)
                Is_Valid_Sign_Number_Validation(8, 13, add_barcode);
            }
        });
        add_barcode.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        add_cate.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                Is_Valid_Cate(add_cate);
            }
        });

        add_name.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                Is_Valid_Product_Name(add_name);
            }
        });

        add_cal.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                Is_Valid_Cal_Name(add_cal);                                                            // do something
            }
        });



        add_save_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // check the value state is null or not
                if (valid_name != null && valid_bar_number != null
                        && valid_cate != null && valid_name.length() != 0
                        && valid_bar_number.length() != 0
                        && valid_cate.length() != 0
                        && valid_cal.length() != 0
                        ) {

                    dbHandler.Add_Product(new Product(valid_name,
                            valid_bar_number, valid_cate, valid_cal));
                    Toast_msg = "Data inserted successfully";
                    Show_Toast(Toast_msg);
                    Reset_Text();

                }

            }
        });

        update_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                valid_name = add_name.getText().toString();
                valid_bar_number = add_barcode.getText().toString();
                valid_cate = add_cate.getText().toString();
                valid_cal = add_cal.getText().toString();

                // check the value state is null or not
                if (valid_name != null && valid_bar_number != null
                        && valid_cate != null && valid_name.length() != 0
                        && valid_bar_number.length() != 0
                        && valid_cate.length() != 0
                        && valid_cal.length() !=0) {

                    dbHandler.Update_Product(new Product(USER_ID, valid_name,
                            valid_bar_number, valid_cate, valid_cal));
                    dbHandler.close();
                    Toast_msg = "Data Update successfully";
                    Show_Toast(Toast_msg);
                    Reset_Text();
                } else {
                    Toast_msg = "Sorry Some Fields are missing.\nPlease Fill up all.";
                    Show_Toast(Toast_msg);
                }

            }
        });
        update_view_all.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent view_user = new Intent(Add_Update.this,
                        Testing.class);
                view_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(view_user);
                finish();
            }
        });

        add_view_all.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent view_user = new Intent(Add_Update.this,
                        Testing.class);
                view_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(view_user);
                finish();
            }
        });

    }

    public void Set_Add_Update_Screen() {

        add_name = (EditText) findViewById(R.id.add_name);
        add_barcode = (EditText) findViewById(R.id.add_barcode);
        add_cate = (EditText) findViewById(R.id.add_cate);
        add_cal = (EditText) findViewById(R.id.add_calories);

        add_save_btn = (Button) findViewById(R.id.add_save_btn);
        update_btn = (Button) findViewById(R.id.update_btn);
        add_view_all = (Button) findViewById(R.id.add_view_all);
        update_view_all = (Button) findViewById(R.id.update_view_all);

        add_view = (LinearLayout) findViewById(R.id.add_view);
        update_view = (LinearLayout) findViewById(R.id.update_view);

        add_view.setVisibility(View.GONE);
        update_view.setVisibility(View.GONE);

    }

    public void Is_Valid_Sign_Number_Validation(int MinLen, int MaxLen,
                                                EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_bar_number = null;
        } else if (edt.getText().toString().length() < MinLen) {
            edt.setError("Minimum length " + MinLen);
            valid_bar_number = null;

        } else if (edt.getText().toString().length() > MaxLen) {
            edt.setError("Maximum length " + MaxLen);
            valid_bar_number = null;

        } else {
            valid_bar_number = edt.getText().toString();

        }

    } // END OF Edittext validation

    public void Is_Valid_Cate(EditText edt)throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Accept Alphabets Only.");
            valid_cate = null;
        } else if (!edt.getText().toString().matches("[a-zA-Z ]+")) {
            edt.setError("Accept Alphabets Only.");
            valid_cate = null;
        } else {
            valid_cate = edt.getText().toString();
        }
    }


    public void Is_Valid_Product_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Accept Alphabets Only.");
            valid_name = null;
        } else if (!edt.getText().toString().matches("[a-zA-Z ]+")) {
            edt.setError("Accept Alphabets Only.");
            valid_name = null;
        } else {
            valid_name = edt.getText().toString();
        }

    }

    public void Is_Valid_Cal_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_cal = null;
        } else {
            valid_cal = edt.getText().toString();

        }

    }

    public void Show_Toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void Reset_Text() {

        add_name.getText().clear();
        add_barcode.getText().clear();
        add_cate.getText().clear();
        add_cal.getText().clear();

    }

}
