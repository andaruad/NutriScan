package com.fyp.andaruad.nutriscan;

public class Product {

    // private variables
    public int _id;
    public String _name;
    public String _barcode;
    public String _cate;
    public String _cal;
    public String _tofat, _sfat, _trfat;
    public String _chole, _sodiu, _carbs, _diefi, _sugr, _prote;
    public String _vitd, _calc, _iron, _potas;
    public Product() {
    }


    public Product(int id, String name, String barcode, String _cate, String _cal) {
        this._id = id;
        this._name = name;
        this._barcode = barcode;
        this._cate = _cate;
        this._cal = _cal;

    }

    public Product(int id, String name, String barcode, String _cate, String _cal, String _tofat, String _sfat, String _trfat) {
        this._id = id;
        this._name = name;
        this._barcode = barcode;
        this._cate = _cate;
        this._cal = _cal;
        this._tofat = _tofat;
        this._sfat = _sfat;
        this._trfat = _trfat;

    }


     //constructor
    public Product(String name, String barcode, String _cate, String _cal) {
        this._name = name;
        this._barcode = barcode;
        this._cate = _cate;
        this._cal = _cal;
    }
    public Product(String name, String barcode, String _cate, String _cal, String _tofat, String _sfat, String _trfat) {
        this._name = name;
        this._barcode = barcode;
        this._cate = _cate;
        this._cal = _cal;
        this._tofat = _tofat;
        this._sfat = _sfat;
        this._trfat = _trfat;
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

    public String getCal() {
        return this._cal;
    }

    public void setCal(String _cal) {
        this._cal = _cal;
    }

    public String get_tofat() {
        return _tofat;
    }

    public void set_tofat(String _tofat) {
        this._tofat = _tofat;
    }

    public String get_sfat() {
        return _sfat;
    }

    public void set_sfat(String _sfat) {
        this._sfat = _sfat;
    }

    public String get_trfat() {
        return _trfat;
    }

    public void set_trfat(String _trfat) {
        this._trfat = _trfat;
    }




}