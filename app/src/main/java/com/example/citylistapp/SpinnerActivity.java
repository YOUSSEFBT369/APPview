package com.example.citylistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_activity);

        // Initialize city list with Moroccan cities
        ArrayList<String> cityList = new ArrayList<>();
        cityList.add("tanger");
        cityList.add("asila");
        cityList.add("laarych");
        cityList.add("chefchaouen");
        cityList.add("fes");
        cityList.add("marrakech");
        cityList.add("asfi");
        cityList.add("sidi bennour");
        cityList.add("el jadida");
        cityList.add("casablanca");
        cityList.add("el hajeb");
        cityList.add("agadir");
        cityList.add("essaouira");
        cityList.add("guelmim");
        cityList.add("tata");
        cityList.add("oujda");
        cityList.add("tantan");
        cityList.add("nador");
        cityList.add("beni mellal");

        // Set up Spinner
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                cityList
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}