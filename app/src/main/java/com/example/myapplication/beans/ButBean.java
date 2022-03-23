package com.example.myapplication.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ButBean implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("specialite")
    @Expose
    private String specialite;


    public ButBean(int id, String specialite) {
        this.id = id;
        this.specialite = specialite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    @Override
    public String toString() {
        return Character.toUpperCase(specialite.toCharArray()[0]) + String.valueOf(specialite.toCharArray()).substring(1);
    }
}
//json to bean