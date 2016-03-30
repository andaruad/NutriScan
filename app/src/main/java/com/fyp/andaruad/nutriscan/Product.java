package com.fyp.andaruad.nutriscan;

public class Product {

    // private variables
    public int _id;
    public String _name;
    public String _barcode;
    public String _cate;

    public Product() {
    }

    // constructor
    public Product(int id, String name, String barcode, String _cate) {
        this._id = id;
        this._name = name;
        this._barcode = barcode;
        this._cate = _cate;

    }

    // constructor
    public Product(String name, String barcode, String _cate) {
        this._name = name;
        this._barcode = barcode;
        this._cate = _cate;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int id) {
        this._id = id;
    }

    // getting name
    public String getName() {
        return this._name;
    }

    // setting name
    public void setName(String name) {
        this._name = name;
    }

    // getting phone number
    public String getBarcodeNumber() {
        return this._barcode;
    }

    // setting phone number
    public void setBarcodeNumber(String barcode) {
        this._barcode = barcode;
    }

    // getting category
    public String getCate() {
        return this._cate;
    }

    // setting category
    public void setCate(String cate) {
        this._cate = cate;
    }

}