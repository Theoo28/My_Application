package com.example.myapplication.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UEBean {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idBut")
    @Expose
    private Integer idBut;
    @SerializedName("semestre")
    @Expose
    private Integer semestre;
    @SerializedName("numero")
    @Expose
    private Integer numero;
    @SerializedName("idCompetence")
    @Expose
    private Integer idCompetence;
    @SerializedName("parcours")
    @Expose
    private String parcours;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdBut() {
        return idBut;
    }

    public void setIdBut(Integer idBut) {
        this.idBut = idBut;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Integer idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getParcours() {
        return parcours;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }

    @Override
    public String toString() {
        return "UEBean{" +
                "id=" + id +
                ", idBut=" + idBut +
                ", semestre=" + semestre +
                ", numero=" + numero +
                ", idCompetence=" + idCompetence +
                ", parcours='" + parcours + '\'' +
                '}';
    }
}