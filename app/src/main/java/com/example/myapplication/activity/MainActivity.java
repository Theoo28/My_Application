package com.example.myapplication.activity;

import static com.example.myapplication.utils.ButUtils.loadBut;
import static com.example.myapplication.utils.UEUtils.loadUE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.beans.ButBean;
import com.example.myapplication.beans.UEBean;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<ButBean> listButBean = null;
    private ArrayList<UEBean> listUEBean = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityMainBinding facilite l'accès aux ressources
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Activation du Dark Mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        Thread thread = new Thread(() -> {
            try {
                //liste données du spinner
                listButBean = loadBut();
                Log.w("reponse", String.valueOf(listButBean));
                runOnUiThread(() -> {

                    // (@resource) android.R.layout.simple_spinner_item:
                    // The resource ID for a layout file containing a TextView to use when instantiating views.
                    // (Layout for one ROW of Spinner)
                    ArrayAdapter<ButBean> adapter = new ArrayAdapter<ButBean>(this,
                            android.R.layout.simple_spinner_item,
                            listButBean);

                    // Layout for All ROWs of Spinner.  (Optional for ArrayAdapter).
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    binding.spinnerBUT.setAdapter(adapter);

                    // When user select a List-Item.
                    //ouverture du spinner
                    binding.spinnerBUT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        //fonction qui existe
                        //selectionne l'item du spinner
                        //hanbler : event onChange
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            onItemSelectedHandler(parent, view, position, id);
                        }

                        @Override
                        //selectionne rien
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    private void onItemSelectedHandler(AdapterView<?> adapterView, View view, int position, long id) {
        //affiche le numero selectionné ; Toast c com le syso
        Adapter adapter = adapterView.getAdapter();
        ButBean butBeanSelected = (ButBean) adapter.getItem(position);

        showListUE(butBeanSelected);

        Toast.makeText(getApplicationContext(), "BUT: " + butBeanSelected, Toast.LENGTH_SHORT).show();
    }

    public void showListUE(ButBean butBean) {
        Thread thread = new Thread(() -> {
            try {
                listUEBean = loadUE(butBean.getId());
                Log.w("reponse", String.valueOf(listUEBean));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
