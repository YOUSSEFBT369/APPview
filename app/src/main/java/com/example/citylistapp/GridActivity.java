package com.example.citylistapp; // Change to your package name

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_activity);

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

        // Set up GridView
        GridView gridView = findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.grid_item,
                R.id.textViewCity,
                cityList
        );
        gridView.setAdapter(adapter);
    }
}
