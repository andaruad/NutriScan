package com.fyp.andaruad.nutriscan;

/**
 * Created by Andaruad on 22/02/2016.
 */
public class ProductsDB  {

    public String p_name;
    public int p_calories;

public ProductsDB(String p_name, int p_calories){

    this.p_name = p_name;
    this.p_calories = p_calories;
}

public String getp_name(){
    return p_name;
}

public int getp_calories(){
    return p_calories;
}

public void setp_name(String p_name) {
    this.p_name = p_name;
}

public void setp_calories (int p_calories){
    this.p_calories = p_calories;
}

//
}
