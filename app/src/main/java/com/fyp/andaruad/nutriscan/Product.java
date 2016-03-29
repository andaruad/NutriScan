package com.fyp.andaruad.nutriscan;

public class Product {

    // private variables
    public int _id;
    public String _name;
    public String _barcode;
    public String _email;

    public Product() {
    }

    // constructor
    public Product(int id, String name, String barcode, String _email) {
        this._id = id;
        this._name = name;
        this._barcode = barcode;
        this._email = _email;

    }

    // constructor
    public Product(String name, String barcode, String _email) {
        this._name = name;
        this._barcode = barcode;
        this._email = _email;
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
    public String getPhoneNumber() {
        return this._barcode;
    }

    // setting phone number
    public void setPhoneNumber(String barcode) {
        this._barcode = barcode;
    }

    // getting email
    public String getEmail() {
        return this._email;
    }

    // setting email
    public void setEmail(String email) {
        this._email = email;
    }

}