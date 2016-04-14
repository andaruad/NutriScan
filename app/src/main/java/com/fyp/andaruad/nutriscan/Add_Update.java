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
    EditText add_name, add_barcode, add_cate, add_cal, add_tofat, add_sfat, add_trfat, add_sersi;
    EditText add_chloe, add_sodiu, add_carbs, add_diefi, add_sugr, add_prote, add_vitd, add_calc, add_iron, add_potas;
    Button add_save_btn, add_view_all, update_btn, update_view_all;
    LinearLayout add_view, update_view;
    String valid_bar_number = null, valid_cate = null, valid_name = null,valid_cal = null,
            valid_tofat = null, valid_sfat = null, valid_trfat = null,
            valid_chloe=null, valid_sodiu=null, valid_carbs=null, valid_dietfi=null, valid_sugr=null, valid_prote=null, valid_vitd=null,
            valid_calc=null, valid_iron=null, valid_potas=null, valid_sersi=null,
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
            add_tofat.setText(c.get_tofat());
            add_sfat.setText(c.get_sfat());
            add_trfat.setText(c.get_trfat());

            add_chloe.setText(c.get_chole());
            add_sodiu.setText(c.get_sodiu());
            add_carbs.setText(c.get_carbs());
            add_diefi.setText(c.get_diefi());
            add_sugr.setText(c.get_sugr());
            add_prote.setText(c.get_prote());
            add_calc.setText(c.get_calc());
            add_vitd.setText(c.get_vitd());
            add_iron.setText(c.get_iron());
            add_potas.setText(c.get_potas());
            add_sersi.setText(c.get_sersi());
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

        add_tofat.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_tofat_Name(add_tofat);                                                            // do something
            }
        });

        add_sfat.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_sfat_Name(add_sfat);                                                            // do something
            }
        });

        add_trfat.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_trfat_Name(add_trfat);                                                            // do something
            }
        });

        add_chloe.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_chloe_Name(add_chloe);                                                            // do something
            }
        });

        add_sodiu.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_sodiu_Name(add_sodiu);                                                            // do something
            }
        });

        add_carbs.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_carbs_Name(add_carbs);                                                            // do something
            }
        });

        add_diefi.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_diefi_Name(add_diefi);                                                            // do something
            }
        });

        add_sugr.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_sugr_Name(add_sugr);                                                            // do something
            }
        });

        add_prote.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_prote_Name(add_prote);                                                            // do something
            }
        });


        add_vitd.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_vitd_Name(add_vitd);                                                            // do something
            }
        });

        add_calc.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_calc_Name(add_calc);                                                            // do something
            }
        });

        add_iron.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_iron_Name(add_iron);                                                            // do something
            }
        });

        add_potas.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_potas_Name(add_potas);                                                            // do something
            }
        });

        add_sersi.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_sersi_Name(add_sersi);                                                            // do something
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
                        && valid_tofat.length() != 0
                        && valid_sfat.length() != 0
                        && valid_trfat.length() != 0

                        && valid_chloe.length() != 0
                        && valid_sodiu.length() != 0
                        && valid_carbs.length() != 0
                        && valid_dietfi.length() != 0
                        && valid_sugr.length() != 0
                        && valid_prote.length() != 0
                        && valid_vitd.length() != 0
                        && valid_calc.length() != 0
                        && valid_iron.length() != 0
                        && valid_potas.length() != 0
                        && valid_sersi.length() !=0
                        ) {

                    dbHandler.Add_Product(new Product(valid_name,
                            valid_bar_number, valid_cate, valid_cal, valid_tofat, valid_sfat, valid_trfat,
                            valid_chloe,valid_sodiu,valid_carbs,valid_dietfi,valid_sugr,valid_prote,valid_vitd,
                            valid_calc,valid_iron,valid_potas,valid_sersi
                    ));
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
                valid_tofat = add_tofat.getText().toString();
                valid_sfat = add_sfat.getText().toString();
                valid_trfat = add_trfat.getText().toString();

                valid_chloe = add_chloe.getText().toString();
                valid_sodiu = add_sodiu.getText().toString();
                valid_carbs = add_carbs.getText().toString();
                valid_dietfi = add_diefi.getText().toString();
                valid_sugr = add_sugr.getText().toString();
                valid_prote = add_prote.getText().toString();
                valid_vitd = add_vitd.getText().toString();
                valid_calc = add_calc.getText().toString();
                valid_iron = add_iron.getText().toString();
                valid_potas = add_potas.getText().toString();
                valid_sersi = add_sersi.getText().toString();




                // check the value state is null or not
                if (valid_name != null && valid_bar_number != null
                        && valid_cate != null && valid_name.length() != 0
                        && valid_bar_number.length() != 0
                        && valid_cate.length() != 0
                        && valid_cal.length() !=0
                        && valid_tofat.length() != 0
                        && valid_sfat.length() != 0
                        && valid_trfat.length() != 0

                        && valid_chloe.length() != 0
                        && valid_sodiu.length() != 0
                        && valid_carbs.length() != 0
                        && valid_dietfi.length() != 0
                        && valid_sugr.length() != 0
                        && valid_prote.length() != 0
                        && valid_vitd.length() != 0
                        && valid_calc.length() != 0
                        && valid_iron.length() != 0
                        && valid_potas.length() != 0
                        && valid_sersi.length() !=0
                        ) {

                    dbHandler.Update_Product(new Product(USER_ID, valid_name,
                            valid_bar_number, valid_cate, valid_cal, valid_tofat, valid_sfat, valid_trfat,
                            valid_chloe,valid_sodiu,valid_carbs,valid_dietfi,valid_sugr,valid_prote,valid_vitd,
                            valid_calc,valid_iron,valid_potas, valid_sersi
                    ));
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
                        Addlist.class);
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
                        Addlist.class);
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
        add_tofat = (EditText) findViewById(R.id.add_tofat);
        add_sfat = (EditText) findViewById(R.id.add_sfat);
        add_trfat = (EditText) findViewById(R.id.add_trfat);

        add_potas = (EditText) findViewById(R.id.add_potas);
        add_prote = (EditText) findViewById(R.id.add_prote);
        add_sugr = (EditText) findViewById(R.id.add_sugr);
        add_diefi = (EditText) findViewById(R.id.add_diefi);
        add_carbs = (EditText) findViewById(R.id.add_carbs);
        add_iron = (EditText) findViewById(R.id.add_iron);
        add_calc = (EditText) findViewById(R.id.add_calc);
        add_chloe = (EditText) findViewById(R.id.add_chloe);
        add_sodiu = (EditText) findViewById(R.id.add_sodiu);
        add_vitd = (EditText) findViewById(R.id.add_vitd);
        add_sersi = (EditText) findViewById(R.id.add_sersi);


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


    public void Is_Valid_Product_Name(EditText edt) {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Field can't be empty");
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


    public void Is_Valid_tofat_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_tofat = null;
        } else {
            valid_tofat = edt.getText().toString();

        }

    }

    public void Is_Valid_sfat_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_sfat = null;
        } else {
            valid_sfat = edt.getText().toString();

        }

    }

    public void Is_Valid_trfat_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_trfat = null;
        } else {
            valid_trfat = edt.getText().toString();

        }

    }




    public void Is_Valid_chloe_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_chloe = null;
        } else {
            valid_chloe = edt.getText().toString();

        }

    }

    public void Is_Valid_sodiu_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_sodiu = null;
        } else {
            valid_sodiu = edt.getText().toString();

        }

    }

    public void Is_Valid_carbs_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_carbs = null;
        } else {
            valid_carbs = edt.getText().toString();

        }

    }
    public void Is_Valid_diefi_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_dietfi = null;
        } else {
            valid_dietfi = edt.getText().toString();

        }

    }

    public void Is_Valid_sugr_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_sugr = null;
        } else {
            valid_sugr = edt.getText().toString();

        }

    }

    public void Is_Valid_prote_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_prote = null;
        } else {
            valid_prote = edt.getText().toString();

        }

    }
    public void Is_Valid_vitd_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_vitd = null;
        } else {
            valid_vitd = edt.getText().toString();

        }

    }

    public void Is_Valid_calc_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_calc = null;
        } else {
            valid_calc = edt.getText().toString();

        }

    }

    public void Is_Valid_iron_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_iron = null;
        } else {
            valid_iron = edt.getText().toString();

        }

    }

    public void Is_Valid_potas_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_potas = null;
        } else {
            valid_potas = edt.getText().toString();

        }

    }
    public void Is_Valid_sersi_Name(EditText edt) throws NumberFormatException {
        if (edt.getText().toString().length() <= 0) {
            edt.setError("Number Only");
            valid_sersi = null;
        } else {
            valid_sersi = edt.getText().toString();

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
        add_tofat.getText().clear();add_sfat.getText().clear();add_trfat.getText().clear();

        add_chloe.getText().clear();
        add_sodiu.getText().clear();
        add_carbs.getText().clear();
        add_diefi.getText().clear();
        add_sugr.getText().clear();
        add_prote.getText().clear();
        add_vitd.getText().clear();
        add_calc.getText().clear();
        add_iron.getText().clear();
        add_potas.getText().clear();
        add_sersi.getText().clear();
    }

}
