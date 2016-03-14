package com.fyp.andaruad.nutriscan;

// * Created by Andaruad on 22/02/2016.

public class Product  {
    private String p_name;
    private String p_barcode;
    private String p_category;
    private int id;

    public Product(){

    }

    public Product(String p_barcode) {
        this.p_barcode = p_barcode;
    }

    public Product(int id, String p_name, String p_barcode, String p_category) {
        this.id = id;
        this.p_name = p_name;
        this.p_barcode = p_barcode;
        this.p_category = p_category;
    }

    public Product(String p_name, String p_barcode, String p_category) {
        this.p_name = p_name;
        this.p_barcode = p_barcode;
        this.p_category = p_category;
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

    public String getP_category() {
        return p_category;
    }

    public void setP_category(String p_category) {
        this.p_category = p_category;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }


}
