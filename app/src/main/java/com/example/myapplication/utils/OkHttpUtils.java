package com.example.myapplication.utils;

import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// OkHttpUtils sert à gérer l'appel aux APIs

public class OkHttpUtils {
    public static String sendGetOkHttpRequest(String url) throws Exception {
        OkHttpClient client = new OkHttpClient();
        //Création de la requête
        Request request = new Request.Builder().url(url).build();
        //Execution de la requête
        Response response = client.newCall(request).execute();
        //Analyse du code retour
        if (response.code() < 200 || response.code() >= 300) {
            throw new Exception("Réponse du serveur incorrect : " + response.code());
        } else {
            //Résultat de la requête
            //ATTENTION .string() ne peut être appelée qu'une seule fois
            return Objects.requireNonNull(response.body()).string();
        }
    }

}
