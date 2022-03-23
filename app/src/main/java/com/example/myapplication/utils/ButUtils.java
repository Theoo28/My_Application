package com.example.myapplication.utils;

import com.example.myapplication.beans.ButBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ButUtils {

    public static ArrayList<ButBean> loadBut() throws Exception {
        //Requete avec OKHttpUtils
        String url = "http://infort.gautero.fr/index2022.php?action=get&obj=but";
        String json = OkHttpUtils.sendGetOkHttpRequest(url);
        //Parser le JSON avec le bon bean et GSON
        ArrayList<ButBean> listData = new Gson().fromJson(json, new TypeToken<ArrayList<ButBean>>() {}.getType());
        //Retourner la donnée
        return listData;
    }
}
