package com.example.citylistapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private CityAdapter adapter;
    private ArrayList<City> cityList;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        // Initialize city list with Moroccan cities
        cityList = new ArrayList<>();
        cityList.add(new City("tanger"));
        cityList.add(new City("asila"));
        cityList.add(new City("laarych"));
        cityList.add(new City("chefchaouen"));
        cityList.add(new City("fes"));
        cityList.add(new City("marrakech"));
        cityList.add(new City("asfi"));
        cityList.add(new City("sidi bennour"));
        cityList.add(new City("el jadida"));
        cityList.add(new City("casablanca"));
        cityList.add(new City("el hajeb"));
        cityList.add(new City("agadir"));
        cityList.add(new City("essaouira"));
        cityList.add(new City("guelmim"));
        cityList.add(new City("tata"));
        cityList.add(new City("oujda"));
        cityList.add(new City("tantan"));
        cityList.add(new City("nador"));
        cityList.add(new City("beni mellal"));

        // Set up ListView and adapter
        listView = findViewById(R.id.listView);
        adapter = new CityAdapter(this, cityList);
        listView.setAdapter(adapter);

        // Set up buttons
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnEdit = findViewById(R.id.btnEdit);
        Button btnDelete = findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(v -> showAddDialog());
        btnEdit.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                showEditDialog(selectedPosition);
            } else {
                Toast.makeText(ListActivity.this, "Veuillez sélectionner une ville", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                showDeleteDialog(selectedPosition);
            } else {
                Toast.makeText(ListActivity.this, "Veuillez sélectionner une ville", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_add_city, null);
        builder.setView(view);

        final EditText editTextCity = view.findViewById(R.id.editTextCity);
        Button btnCancel = view.findViewById(R.id.btnCancel);
        Button btnConfirm = view.findViewById(R.id.btnConfirm);

        final AlertDialog dialog = builder.create();
        dialog.show();

        btnCancel.setOnClickListener(v -> dialog.dismiss());
        btnConfirm.setOnClickListener(v -> {
            String cityName = editTextCity.getText().toString().trim();
            if (!cityName.isEmpty()) {
                cityList.add(new City(cityName));
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            } else {
                editTextCity.setError("Veuillez saisir un nom de ville");
            }
        });
    }

    private void showEditDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_edit_city, null);
        builder.setView(view);

        final EditText editTextCity = view.findViewById(R.id.editTextCity);
        Button btnCancel = view.findViewById(R.id.btnCancel);
        Button btnConfirm = view.findViewById(R.id.btnConfirm);

        editTextCity.setText(cityList.get(position).getName());

        final AlertDialog dialog = builder.create();
        dialog.show();

        btnCancel.setOnClickListener(v -> dialog.dismiss());
        btnConfirm.setOnClickListener(v -> {
            String cityName = editTextCity.getText().toString().trim();
            if (!cityName.isEmpty()) {
                cityList.get(position).setName(cityName);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            } else {
                editTextCity.setError("Veuillez saisir un nom de ville");
            }
        });
    }

    private void showDeleteDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Voulez-vous vraiment supprimer cette ville?");
        builder.setNegativeButton("NON", (dialog, which) -> dialog.dismiss());
        builder.setPositiveButton("OUI", (dialog, which) -> {
            cityList.remove(position);
            adapter.notifyDataSetChanged();
            selectedPosition = -1;
        });
        builder.show();
    }

    // Custom adapter for the ListView
    private class CityAdapter extends ArrayAdapter<City> {
        public CityAdapter(Context context, ArrayList<City> cities) {
            super(context, 0, cities);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }

            TextView textViewCity = convertView.findViewById(R.id.textViewCity);
            RadioButton radioButton = convertView.findViewById(R.id.radioButton);

            City city = getItem(position);
            textViewCity.setText(city.getName());
            radioButton.setChecked(position == selectedPosition);

            convertView.setOnClickListener(v -> {
                selectedPosition = position;
                notifyDataSetChanged();
            });

            return convertView;
        }
    }
}