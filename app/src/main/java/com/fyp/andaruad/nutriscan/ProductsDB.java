package com.fyp.andaruad.nutriscan;

// * Created by Andaruad on 22/02/2016.

public class ProductsDB  {

    private String p_barcode;
    private int p_calories;

    public ProductsDB(String p_barcode, int p_calories) {
        this.p_barcode = p_barcode;
        this.p_calories = p_calories;
    }
    public ProductsDB(){

    }

    public String getP_barcode() {
        return p_barcode;
    }

    public void setP_barcode(String p_barcode) {
        this.p_barcode = p_barcode;
    }

    public int getP_calories() {
        return p_calories;
    }

    public void setP_calories(int p_calories) {
        this.p_calories = p_calories;
    }
}
