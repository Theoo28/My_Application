package com.example.myapplication.utils;

import com.example.myapplication.beans.UEBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class UEUtils {

    public static ArrayList<UEBean> loadUE(Integer idBut) throws Exception {
        //Requete avec OKHttpUtils
        String url = "http://infort.gautero.fr/index.php?action=get&obj=ue&idBut=" + idBut;
        String json = OkHttpUtils.sendGetOkHttpRequest(url);
        //Parser le JSON avec le bon bean et GSON
        ArrayList<UEBean> listData = new Gson().fromJson(json, new TypeToken<ArrayList<UEBean>>() {}.getType());
        //Retourner la donnée
        return listData;
    }
}
