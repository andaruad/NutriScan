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

    public Product(int id, String name, String barcode, String _cate, String _cal, String _tofat, String _sfat, String _trfat
                   ,String _chole,String _sodiu,String _carbs,String _diefi,String _sugr,String _prote
                   ,String _vitd,String _calc,String _iron,String _potas
    ) {
        this._id = id;
        this._name = name;
        this._barcode = barcode;
        this._cate = _cate;
        this._cal = _cal;
        this._tofat = _tofat;
        this._sfat = _sfat;
        this._trfat = _trfat;
        this._chole = _chole;
        this._sodiu =_sodiu;
        this._carbs = _carbs;
        this._diefi = _diefi;
        this._sugr = _sugr;
        this._prote = _prote;
        this._vitd = _vitd;
        this._calc=_calc;
        this._iron=_iron;
        this._potas=_potas;

    }


     //constructor
    public Product(String name, String barcode, String _cate, String _cal) {
        this._name = name;
        this._barcode = barcode;
        this._cate = _cate;
        this._cal = _cal;
    }
    public Product(String name, String barcode, String _cate, String _cal, String _tofat, String _sfat, String _trfat
            ,String _chole,String _sodiu,String _carbs,String _diefi,String _sugr,String _prote
            ,String _vitd,String _calc,String _iron,String _potas
    ) {
        this._name = name;
        this._barcode = barcode;
        this._cate = _cate;
        this._cal = _cal;
        this._tofat = _tofat;
        this._sfat = _sfat;
        this._trfat = _trfat;
        this._chole = _chole;
        this._sodiu =_sodiu;
        this._carbs = _carbs;
        this._diefi = _diefi;
        this._sugr = _sugr;
        this._prote = _prote;
        this._vitd = _vitd;
        this._calc=_calc;
        this._iron=_iron;
        this._potas=_potas;

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

    public String get_chole() {
        return _chole;
    }

    public void set_chole(String _chole) {
        this._chole = _chole;
    }

    public String get_sodiu() {
        return _sodiu;
    }

    public void set_sodiu(String _sodiu) {
        this._sodiu = _sodiu;
    }

    public String get_carbs() {
        return _carbs;
    }

    public void set_carbs(String _carbs) {
        this._carbs = _carbs;
    }

    public String get_diefi() {
        return _diefi;
    }

    public void set_diefi(String _diefi) {
        this._diefi = _diefi;
    }

    public String get_sugr() {
        return _sugr;
    }

    public void set_sugr(String _sugr) {
        this._sugr = _sugr;
    }

    public String get_prote() {
        return _prote;
    }

    public void set_prote(String _prote) {
        this._prote = _prote;
    }

    public String get_vitd() {
        return _vitd;
    }

    public void set_vitd(String _vitd) {
        this._vitd = _vitd;
    }

    public String get_calc() {
        return _calc;
    }

    public void set_calc(String _calc) {
        this._calc = _calc;
    }

    public String get_iron() {
        return _iron;
    }

    public void set_iron(String _iron) {
        this._iron = _iron;
    }

    public String get_potas() {
        return _potas;
    }

    public void set_potas(String _potas) {
        this._potas = _potas;
    }
}