package com.fyp.andaruad.nutriscan;

// * Created by Andaruad on 22/02/2016.

public class Product  {
    private String p_name;
    private String p_barcode;
    private String p_calories;
    private int id;

    public Product(){

    }

    public Product(String p_barcode) {
        this.p_barcode = p_barcode;
    }

    public Product(int id, String p_name, String p_barcode, String p_calories) {
        this.id = id;
        this.p_name = p_name;
        this.p_barcode = p_barcode;
        this.p_calories = p_calories;
    }

    public Product(String p_name, String p_barcode, String p_calories) {
        this.p_name = p_name;
        this.p_barcode = p_barcode;
        this.p_calories = p_calories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getP_barcode() {
        return p_barcode;
    }

    public void setP_barcode(String p_barcode) {
        this.p_barcode = p_barcode;
    }

    public String getP_calories() {
        return p_calories;
    }

    public void setP_calories(String p_calories) {
        this.p_calories = p_calories;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }


}
